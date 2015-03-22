package com.sp.fanikiwa.api;

import static com.sp.fanikiwa.api.OfyService.ofy;

import com.sp.fanikiwa.entity.Account;
import com.sp.fanikiwa.entity.AccountLimitStatus;
import com.sp.fanikiwa.entity.Customer;
import com.sp.fanikiwa.entity.DoubleEntry;
import com.sp.fanikiwa.entity.Member;
import com.sp.fanikiwa.entity.MultiEntry;
import com.sp.fanikiwa.entity.PassFlag;
import com.sp.fanikiwa.entity.Transaction;
import com.sp.fanikiwa.entity.TransactionType;
import com.sp.fanikiwa.entity.ValueDatedTransaction;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.google.api.server.spi.config.Nullable;
import com.google.api.server.spi.response.CollectionResponse;
import com.google.api.server.spi.response.ConflictException;
import com.google.api.server.spi.response.NotFoundException;
import com.google.appengine.api.datastore.Cursor;
import com.google.appengine.api.datastore.QueryResultIterator;
import com.googlecode.objectify.VoidWork;
import com.googlecode.objectify.Work;
import com.googlecode.objectify.cmd.Query;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;

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
			@Nullable @Named("count") Integer count) {

		Query<Account> query = ofy().load().type(Account.class);
		return GetAccountByQuery(query,  cursorString, count);
	}
	@ApiMethod(name = "listMemberAccount")
	public CollectionResponse<Account> listMemberAccount(Long MemberId,
			@Nullable @Named("cursor") String cursorString,
			@Nullable @Named("count") Integer count) {

		Member member = ofy().load().type(Member.class).id(MemberId).now();
		//Customer customer = ofy().load().type(Customer.class).id(member.getCustomer()).now();
		Query<Account> query = ofy().load().type(Account.class).filter("customer",member.getCustomer());
		
		return GetAccountByQuery(query,  cursorString, count);
	}
	
	@ApiMethod(name = "listAccountTransactions")
	public CollectionResponse<Transaction> listAccountTransactions(Long AccountId,
			@Nullable @Named("cursor") String cursorString,
			@Nullable @Named("count") Integer count) {

		TransactionEndpoint tep = new TransactionEndpoint();
		
		return tep.listAccountTransaction(AccountId, cursorString, count);
	}
	
	
	private CollectionResponse<Account> GetAccountByQuery(Query<Account> query, String cursorString,Integer count)
			{
		if (count != null)
			query.limit(count);
		if (cursorString != null && cursorString != "") {
			query = query.startAt(Cursor.fromWebSafeString(cursorString));
		}

		List<Account> records = new ArrayList<Account>();
		QueryResultIterator<Account> iterator = query.iterator();
		int num = 0;
		while (iterator.hasNext()) {
			records.add(iterator.next());
			if (count != null) {
				num++;
				if (num == count)
					break;
			}
		}

		// Find the next cursor
		if (cursorString != null && cursorString != "") {
			Cursor cursor = iterator.getCursor();
			if (cursor != null) {
				cursorString = cursor.toWebSafeString();
			}
		}
		return CollectionResponse.<Account> builder().setItems(records)
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
		return findRecord(id);
	}

	/**
	 * This inserts a new entity into App Engine datastore. If the entity
	 * already exists in the datastore, an exception is thrown. It uses HTTP
	 * POST method.
	 *
	 * @param Account
	 *            the entity to be inserted.
	 * @return The inserted entity.
	 * @throws ConflictException
	 */
	@ApiMethod(name = "insertAccount")
	public Account insertAccount(Account Account) throws ConflictException {
		if (Account.getAccountID() != null) {
			if (findRecord(Account.getAccountID()) != null) {
				throw new ConflictException("Object already exists");
			}
		}
		ofy().save().entities(Account).now();
		return Account;
	}

	/**
	 * This method is used for updating an existing entity. If the entity does
	 * not exist in the datastore, an exception is thrown. It uses HTTP PUT
	 * method.
	 *
	 * @param Account
	 *            the entity to be updated.
	 * @return The updated entity.
	 * @throws NotFoundException
	 */
	@ApiMethod(name = "updateAccount")
	public Account updateAccount(Account Account) throws NotFoundException {
		Account record = findRecord(Account.getAccountID());
		if (record == null) {
			throw new NotFoundException("Record does not exist");
		}
		ofy().save().entities(Account).now();
		return Account;
	}

	/**
	 * This method removes the entity with primary key id. It uses HTTP DELETE
	 * method.
	 *
	 * @param id
	 *            the primary key of the entity to be deleted.
	 * @throws NotFoundException
	 */
	@ApiMethod(name = "removeAccount")
	public void removeAccount(@Named("id") Long id) throws NotFoundException {
		Account record = findRecord(id);
		if (record == null) {
			throw new NotFoundException("Record does not exist");
		}
		ofy().delete().entity(record).now();
	}

	private Account findRecord(Long id) {
		return ofy().load().type(Account.class).id(id).now();
	}
  
	@ApiMethod(name = "BlockFunds")
	public void BlockFunds(Account account, @Named("blockamount") double amount)
			throws NotFoundException {
		Account acc = findRecord(account.getAccountID());
		this.MarkLimit(acc, amount);
	}

	@ApiMethod(name = "ClearEffects")
	public void ClearEffects(Account account, @Named("amount") double amount)
			throws NotFoundException {
		Account acc = findRecord(account.getAccountID());
		acc.setClearedBalance(account.getClearedBalance() + amount);
		this.updateAccount(acc);
	}

	@ApiMethod(name = "CloseAccount")
	public void CloseAccount(Account account) throws NotFoundException {
		Account acc = findRecord(account.getAccountID());
		acc.setClosed(true);
		this.updateAccount(acc);
	}

	@ApiMethod(name = "SetAccountLimitStatus")
	public void SetAccountLimitStatus(Account account,
			@Named("status") AccountLimitStatus status)
			throws NotFoundException {
		Account acc = findRecord(account.getAccountID());
		acc.setLimitFlag(status.ordinal());
		this.updateAccount(acc);
	}

	@ApiMethod(name = "SetAccountLockStatus")
	public void SetAccountLockStatus(Account account,
			@Named("status") PassFlag status) throws NotFoundException {
		Account acc = findRecord(account.getAccountID());
		acc.setPassFlag(status.ordinal());
		this.updateAccount(acc);
	}

	@ApiMethod(name = "UnBlockFunds")
	public void UnBlockFunds(Account account, @Named("amount") double amount)
			throws NotFoundException {
		Account acc = findRecord(account.getAccountID());
		this.MarkLimit(acc, amount * -1);
	}

	@ApiMethod(name = "BatchPost")
	public void BatchPost(final MultiEntry multiEntry) {
		ofy().transact(new VoidWork() {
			public void vrun() {
				for (Transaction transaction : multiEntry.getTransactions()) {
					Post(transaction);
				}

			}
		});
	}

	@ApiMethod(name = "DoubleEntryPost")
	public void DoubleEntryPost(final DoubleEntry doubleEntry) {
		ofy().transact(new VoidWork() {
			public void vrun() {
				Post(doubleEntry.getDr());
				Post(doubleEntry.getCr());
			}
		});
	}

	@ApiMethod(name = "Post")
	public void Post(final Transaction transaction) {
		ofy().transact(new VoidWork() {
			public void vrun() {
				try {
					postAtomic(transaction);
				} catch (NotFoundException | ConflictException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}

	private void postAtomic(Transaction transaction) throws NotFoundException,
			ConflictException {

		Account account = findRecord(transaction.getAccount().getAccountID());
		// Step 1: Validate
		ValidatePost(account, transaction);

		// Step 2 - Insert new transaction.
		// /TODO Confirm this is legal/best practice
		TransactionEndpoint txn = new TransactionEndpoint();
		txn.insertTransaction(transaction);

		// Step 3 - Update balance and value date.
		// On Before Book Balance Changed
		account.setBookBalance(account.getBookBalance()
				+ transaction.getAmount());

		// If postdate == valuedate clear the funds immediately
		if (transaction.getValueDate() == transaction.getPostDate()) {
			// On Before Cleared Balance Changed
			// StaticPostingComponent.ClearEffects(Account account, decimal
			// amount)
			account.setClearedBalance(account.getClearedBalance()
					+ transaction.getAmount());
		} else if (transaction.getValueDate().after(transaction.getPostDate())) {
			// this is a value dated transaction,
			// enter a valuedated diary record if a diary

			ValueDatedTransaction vt = new ValueDatedTransaction();
			vt.setAccount(transaction.getAccount());
			vt.setAmount(transaction.getAmount());
			vt.setAuthorizer(transaction.getAuthorizer());
			vt.setForcePostFlag(transaction.getForcePostFlag());
			vt.setNarrative(transaction.getNarrative());
			vt.setPostDate(transaction.getPostDate());
			vt.setRecordDate(transaction.getRecordDate());
			vt.setStatementFlag(transaction.getStatementFlag());
			vt.setTransactionID(transaction.getTransactionID());
			vt.setTransactionType(transaction.getTransactionType());
			vt.setUserID(transaction.getUserID());
			vt.setValueDate(transaction.getValueDate());

			// persist vt
			ValueDatedTransactionEndpoint vtxn = new ValueDatedTransactionEndpoint();
			vtxn.insertValueDatedTransaction(vt);
		} else {
			throw new NotFoundException(
					"Back dated transaction posting not supported");
		}

		// Step 4 - Persist.
		updateAccount(account);

	}

	private void ValidatePost(Account account, Transaction transaction)
			throws NotFoundException {
		if (account.getClosed())
			throw new NotFoundException("Account closed");
		if (transaction == null)
			throw new NotFoundException("transaction is null");

		// Step 1 - See if we can post into this account by looking at lock and
		// limit flags.
		double AmountAvailableOnUncleared = account.getBookBalance()
				- account.getLimit();
		double AmountAvailableAfterTxn = account.getClearedBalance()
				+ transaction.getAmount();

		// get account status
		AccountLimitStatus limistatus = AccountLimitStatus.values()[account
				.getLimitFlag()];
		PassFlag lockstatus = PassFlag.values()[account.getPassFlag()];

		// transaction type
		TransactionType _TransactionType = transaction.getTransactionType();

		// Do account status tests only if the transaction is not a force post
		if (!transaction.getForcePostFlag()) {
			// check 1 - Lock status
			if ((lockstatus == PassFlag.Locked)
					|| (lockstatus == PassFlag.AllPostingProhibited)
					|| (lockstatus == PassFlag.CreditPostingProhibited && _TransactionType
							.getDebitCredit().equals("C"))
					|| (lockstatus == PassFlag.DebitPostingProhibited && _TransactionType
							.getDebitCredit().equals("D"))) {
				throw new IllegalArgumentException(
						String.format(
								"Account [{0}] posting prohibited.\nAccount lock status =[{2}]",
								account.getAccountID(),
								_TransactionType.getTransactionTypeID(),
								lockstatus.toString()));
			}

			// check 2 - Limit status
			if ((limistatus == AccountLimitStatus.PostingOverDrawingProhibited && AmountAvailableAfterTxn < 0)
					|| (limistatus == AccountLimitStatus.PostingDrawingOnUnclearedEffectsAllowed && AmountAvailableOnUncleared < 0)) {
				throw new IllegalArgumentException(
						String.format(
								"Account [{0}] overdraw prohibited, limit status =[{2}]",
								account.getAccountID(),
								_TransactionType.getTransactionTypeID(),
								limistatus.toString()// Enum.GetName(typeof(AccountStatus),
														// limistatus))
						));
			}
		}

	}

	private void ValidateLimit(Account account, double amount)
			throws NotFoundException {
		if (account.getClosed())
			throw new NotFoundException("Account closed");

		// check that funds are available after limiting
		AccountLimitStatus limistatus = AccountLimitStatus.values()[account
				.getLimitFlag()];
		PassFlag lockstatus = PassFlag.values()[account.getPassFlag()];

		double AmountAvailable = account.getClearedBalance()
				- account.getLimit();
		double AvailableBalanceAfterApplyingLimit = AmountAvailable - amount;
		double limit = account.getLimit() + amount;

		// check 1 - Lock status
		if ((lockstatus == PassFlag.Locked))
			throw new NotFoundException(
					String.format(
							"Cannot mark limit to account [{0}].\nAccount lock status =[{1}]",
							account.getAccountID(), lockstatus));

		// check 2 - Limit status
		if ((limistatus == AccountLimitStatus.AllLimitsProhibited)
				|| (limistatus == AccountLimitStatus.LimitForBlockingProhibited && limit > 0)
				|| (limistatus == AccountLimitStatus.LimitForAdvanceProhibited && limit < 0))
			throw new NotFoundException(
					String.format(
							"Cannot mark limit to account [{0}].\nMarking limits prohibited, limit status =[{1}]",
							account.getAccountID(), limistatus));

		if (limistatus == AccountLimitStatus.LimitsAllowed
				&& AvailableBalanceAfterApplyingLimit < 0)
			throw new NotFoundException(
					String.format(
							"Cannot block funds[{0}] on Acount[{1}]. There are not enough funds to block. Available balance[{2}] is below zero. ",
							amount, account.getAccountID(),
							AvailableBalanceAfterApplyingLimit));

	}

	private void MarkLimit(Account account, double amount)
			throws NotFoundException

	{
		// Step 1 - Block funds mean making funds unavailable
		// funds are made unavailable by increasing the limit.

		// Handle as ACID
		// validate
		ValidateLimit(account, amount);

		// Data access component declarations.
		account.setLimit(account.getLimit() + amount);

		// updateAccount( account);
		updateAccount(account);

	}

}
