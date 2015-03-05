package com.sp.fanikiwa.business;

import com.sp.fanikiwa.entity.Account;
import com.sp.fanikiwa.entity.AccountLimitStatus;
import com.sp.fanikiwa.entity.PassFlag;
import com.sp.fanikiwa.entity.Transaction;
import com.sp.fanikiwa.entity.TransactionType;
import com.sp.fanikiwa.entity.ValueDatedTransaction;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.google.api.server.spi.response.CollectionResponse;
import com.google.appengine.api.datastore.Cursor;
import com.google.appengine.api.datastore.TransactionOptions;
import com.google.appengine.datanucleus.query.JDOCursorHelper;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Nullable;
import javax.inject.Named;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;

@Api(name = "accountendpoint", namespace = @ApiNamespace(ownerDomain = "sp.com", ownerName = "sp.com", packagePath = "fanikiwa.entity"))
public class AccountEndpoint {

	/**
	 * This method lists all the entities inserted in datastore. It uses HTTP
	 * GET method and paging support.
	 *
	 * @return A CollectionResponse class containing the list of all entities
	 *         persisted and a cursor to the next page.
	 */
	@SuppressWarnings({ "unchecked", "unused" })
	@ApiMethod(name = "listAccount")
	public CollectionResponse<Account> listAccount(
			@Nullable @Named("cursor") String cursorString,
			@Nullable @Named("limit") Integer limit) {

		PersistenceManager mgr = null;
		Cursor cursor = null;
		List<Account> execute = null;

		try {
			mgr = getPersistenceManager();
			Query query = mgr.newQuery(Account.class);
			if (cursorString != null && cursorString != "") {
				cursor = Cursor.fromWebSafeString(cursorString);
				HashMap<String, Object> extensionMap = new HashMap<String, Object>();
				extensionMap.put(JDOCursorHelper.CURSOR_EXTENSION, cursor);
				query.setExtensions(extensionMap);
			}

			if (limit != null) {
				query.setRange(0, limit);
			}

			execute = (List<Account>) query.execute();
			cursor = JDOCursorHelper.getCursor(execute);
			if (cursor != null)
				cursorString = cursor.toWebSafeString();

			// Tight loop for fetching all entities from datastore and
			// accomodate
			// for lazy fetch.
			for (Account obj : execute)
				;
		} finally {
			mgr.close();
		}

		return CollectionResponse.<Account> builder().setItems(execute)
				.setNextPageToken(cursorString).build();
	}

	/**
	 * This method gets the entity having primary key id. It uses HTTP GET
	 * method.
	 *
	 * @param id
	 *            the primary key of the java bean.
	 * @return The entity with primary key id.
	 */
	@ApiMethod(name = "getAccount")
	public Account getAccount(@Named("id") Long id) {
		PersistenceManager mgr = getPersistenceManager();
		Account account = null;
		try {
			account = mgr.getObjectById(Account.class, id);
		} finally {
			mgr.close();
		}
		return account;
	}

	/**
	 * This inserts a new entity into App Engine datastore. If the entity
	 * already exists in the datastore, an exception is thrown. It uses HTTP
	 * POST method.
	 *
	 * @param account
	 *            the entity to be inserted.
	 * @return The inserted entity.
	 */
	@ApiMethod(name = "insertAccount")
	public Account insertAccount(Account account) {
		PersistenceManager mgr = getPersistenceManager();
		try {
			if(account.getAccountID() != null)
			{
			if (containsAccount(account)) {
				throw new EntityExistsException("Object already exists");
			}
			}
			mgr.makePersistent(account);
		} finally {
			mgr.close();
		}
		return account;
	}

	/**
	 * This method is used for updating an existing entity. If the entity does
	 * not exist in the datastore, an exception is thrown. It uses HTTP PUT
	 * method.
	 *
	 * @param account
	 *            the entity to be updated.
	 * @return The updated entity.
	 */
	@ApiMethod(name = "updateAccount")
	public Account updateAccount(Account account) {
		PersistenceManager mgr = getPersistenceManager();
		try {
			if (!containsAccount(account)) {
				throw new EntityNotFoundException("Object does not exist");
			}
			mgr.makePersistent(account);
		} finally {
			mgr.close();
		}
		return account;
	}

	/**
	 * This method removes the entity with primary key id. It uses HTTP DELETE
	 * method.
	 *
	 * @param id
	 *            the primary key of the entity to be deleted.
	 */
	@ApiMethod(name = "removeAccount")
	public void removeAccount(@Named("id") Long id) {
		PersistenceManager mgr = getPersistenceManager();
		try {
			Account account = mgr.getObjectById(Account.class, id);
			mgr.deletePersistent(account);
		} finally {
			mgr.close();
		}
	}

	@ApiMethod(name = "BlockFunds")
	public void BlockFunds(Account account, @Named("amount") double amount) {
		// TODO Auto-generated method stub
		this.MarkLimit(account, amount);
	}

	@ApiMethod(name = "ClearEffects")
	public void ClearEffects(Account account, @Named("amount") double amount) {
		// TODO Auto-generated method stub
		account.setClearedBalance(account.getClearedBalance() + amount);
		this.updateAccount(account);
	}

	@ApiMethod(name = "CloseAccount")
	public void CloseAccount(Account account) {
		// TODO Auto-generated method stub
		account.setClosed(true);
		this.updateAccount(account);
	}

	@ApiMethod(name = "SetAccountLimitStatus")
	public void SetAccountLimitStatus(Account acc, @Named("status") AccountLimitStatus status) {
		// TODO Auto-generated method stub
		acc.setLimitFlag(status.ordinal());
		this.updateAccount(acc);
	}

	@ApiMethod(name = "SetAccountLockStatus")
	public void SetAccountLockStatus(Account acc,@Named("status")  PassFlag status) {
		// TODO Auto-generated method stub
		acc.setPassFlag(status.ordinal());
		this.updateAccount(acc);
	}

	@ApiMethod(name = "UnBlockFunds")
	public void UnBlockFunds(Account account, @Named("amount") double amount) {
		// TODO Auto-generated method stub
		this.MarkLimit(account, amount - 1);
	}

	@ApiMethod(name = "Post")
	public void Post(Transaction transaction) {

		
		PersistenceManager mgr = getPersistenceManager();
/*
 * It is not possible to use this per transaction:
		TransactionOptions options = TransactionOptions.Builder.withXG(true);
		Transaction txn = datastore.beginTransaction(options);
		
		so we use this <property name="datanucleus.appengine.datastoreEnableXGTransactions" value="true"/>
		for all transactions
*/
		javax.jdo.Transaction tx = mgr.currentTransaction();
		try {
			tx.begin(); //withXG(true)


		Account account = transaction.getAccount();
		//Step 1: Validate
		ValidatePost( account,  transaction);
		
		// Step 2 - Insert new transaction.
        account.addTransaction(transaction);

        // Step 3 - Update balance and value date.
        //On Before Book Balance Changed
        account.setBookBalance( account.getBookBalance()+ transaction.getAmount());

        //If postdate == valuedate clear the funds immediately
        if (transaction.getValueDate() == transaction.getPostDate())
        {
            //On Before Cleared Balance Changed
            //StaticPostingComponent.ClearEffects(Account account, decimal amount)
            account.setClearedBalance( account.getClearedBalance()+ transaction.getAmount());
        }
        else if (transaction.getValueDate().after(transaction.getPostDate()))
        {
            //this is a value dated transaction, 
            //enter a valuedated diary record if a diary 

            ValueDatedTransaction vt = new ValueDatedTransaction();
            vt.setAccount( transaction.getAccount());
            vt.setAmount(transaction.getAmount());
            vt.setAuthorizer ( transaction.getAuthorizer());
            vt.setForcePostFlag ( transaction.getForcePostFlag());
            vt.setNarrative ( transaction.getNarrative());
            vt.setPostDate ( transaction.getPostDate());
            vt.setRecordDate ( transaction.getRecordDate());
            vt.setStatementFlag ( transaction.getStatementFlag());
            vt.setTransactionID ( transaction.getTransactionID());
            vt.setTransactionType ( transaction.getTransactionType());
            vt.setUserID ( transaction.getUserID());
            vt.setValueDate ( transaction.getValueDate());

            //persist vt
            account.addValueDatedTransaction(vt);
        }
        else
        {
            throw new EntityNotFoundException("Back dated transactions not supported");
        }

     // Step 4 - Persist.
        updateAccount(account);
        
        tx.commit();
		}
		finally
		{
			if(tx.isActive())
			{
				tx.rollback();
			}
		}
	}
	

	private void ValidatePost(Account account, Transaction transaction)
	{
		if (account.getClosed())
			throw new EntityNotFoundException("Account closed");
		if(transaction == null) throw new EntityNotFoundException("transaction is null");

        // Step 1 - See if we can post into this account by looking at lock and limit flags.
        double AmountAvailableOnUncleared = account.getBookBalance() - account.getLimit();
        double AmountAvailableAfterTxn = account.getClearedBalance() + transaction.getAmount();

        //get account status
        AccountLimitStatus limistatus = AccountLimitStatus.values()[ account.getLimitFlag()];
		PassFlag lockstatus = PassFlag.values()[account.getPassFlag()];

		//transaction type
		TransactionType _TransactionType = transaction.getTransactionType();

        //Do account status tests only if the transaction is not a force post
        if (!transaction.getForcePostFlag())
        {
            //check 1 - Lock status
            if ((lockstatus == PassFlag.Locked)
                || (lockstatus == PassFlag.AllPostingProhibited)
                || (lockstatus == PassFlag.CreditPostingProhibited && _TransactionType.getDebitCredit().equals("C"))
                || (lockstatus == PassFlag.DebitPostingProhibited && _TransactionType.getDebitCredit().equals("D"))
                )
            {
            	throw new IllegalArgumentException(String.format("Account [{0}] posting prohibited.\nAccount lock status =[{2}]",
                    account.getAccountID(),
                    _TransactionType.getTransactionTypeID(),
                    lockstatus.toString()));
            }

            //check 2 - Limit status
            if ((limistatus == AccountLimitStatus.PostingOverDrawingProhibited && AmountAvailableAfterTxn < 0)
                || (limistatus == AccountLimitStatus.PostingDrawingOnUnclearedEffectsAllowed && AmountAvailableOnUncleared < 0)
                )
            {
            	throw new IllegalArgumentException(String.format("Account [{0}] overdraw prohibited, limit status =[{2}]",
                    account.getAccountID(),
                    _TransactionType.getTransactionTypeID(),
                    limistatus.toString()// Enum.GetName(typeof(AccountStatus), limistatus))
                    ));
            }
        }

	}
	private boolean containsAccount(Account account) {
		return containsAccount(account.getAccountID());
	}

	private boolean containsAccount(long accountID) {
		PersistenceManager mgr = getPersistenceManager();
		boolean contains = true;
		try {
			mgr.getObjectById(Account.class, accountID);
		} catch (javax.jdo.JDOObjectNotFoundException ex) {
			contains = false;
		} finally {
			mgr.close();
		}
		return contains;
	}

	private void ValidateLimit(Account account, double amount)
	{
		if (account.getClosed())
			throw new EntityNotFoundException("Account closed");

		// check that funds are available after limiting
		AccountLimitStatus limistatus = AccountLimitStatus.values()[ account.getLimitFlag()];
		PassFlag lockstatus = PassFlag.values()[account.getPassFlag()];

		double AmountAvailable = account.getClearedBalance()
				- account.getLimit();
		double AvailableBalanceAfterApplyingLimit = AmountAvailable
				- amount;
		double limit = account.getLimit() + amount;

		// check 1 - Lock status
		if ((lockstatus == PassFlag.Locked))
			throw new EntityNotFoundException(
					String.format(
							"Cannot mark limit to account [{0}].\nAccount lock status =[{1}]",
							account.getAccountID(), lockstatus));

		// check 2 - Limit status
		if ((limistatus == AccountLimitStatus.AllLimitsProhibited)
				|| (limistatus == AccountLimitStatus.LimitForBlockingProhibited && limit > 0)
				|| (limistatus == AccountLimitStatus.LimitForAdvanceProhibited && limit < 0))
			throw new EntityNotFoundException(
					String.format(
							"Cannot mark limit to account [{0}].\nMarking limits prohibited, limit status =[{1}]",
							account.getAccountID(), limistatus));

		if (limistatus == AccountLimitStatus.LimitsAllowed
				&& AvailableBalanceAfterApplyingLimit < 0)
			throw new EntityNotFoundException(
					String.format(
							"Cannot block funds[{0}] on Acount[{1}]. There are not enough funds to block. Available balance[{2}] is below zero. ",
							amount, account.getAccountID(),
							AvailableBalanceAfterApplyingLimit));

	}
	private void MarkLimit(Account account, double amount)

	{
		// Step 1 - Block funds mean making funds unavailable
		// funds are made unavailable by increasing the limit.

		// Handle as ACID
		PersistenceManager mgr = getPersistenceManager();
		try {

			javax.jdo.Transaction tx = mgr.currentTransaction();
			try {
				tx.begin();
				//validate
				ValidateLimit( account,  amount);
				
				// Data access component declarations.
				account.setLimit(account.getLimit() + amount);
				// updateAccount( account);
				mgr.makePersistent(account);
				tx.commit();
			} finally {
				if (tx.isActive()) {
					tx.rollback();
				}
			}
		} finally {
			mgr.close();
		}
	}

	private static PersistenceManager getPersistenceManager() {
		return PMF.get().getPersistenceManager();
	}

}
