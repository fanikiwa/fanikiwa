package com.sp.fanikiwa.business;


import java.util.Date;
import java.util.List;


import com.sp.fanikiwa.entity.BatchSimulateStatus;
import com.sp.fanikiwa.entity.Customer;
import com.sp.fanikiwa.entity.SimulatePostStatus;
import com.sp.fanikiwa.entity.TieredDet;
import com.sp.fanikiwa.entity.Transaction;
import com.sp.fanikiwa.entity.TransactionModel;
import com.sp.fanikiwa.entity.TransactionType;

public interface IGL {
	// Accounts and Transactions
	boolean BatchPost(List<Transaction> Trans);

	void PostSingle(Transaction transaction);

	SimulatePostStatus SimulatePostSingle(Transaction transaction);

	BatchSimulateStatus SimulatePostBatch(List<Transaction> transactions);

	
	List<TieredDet> GetTieredTable(Long tieredID);

	// Transactions
	List<Transaction> GetAccountTransactionsByDate(int accountId,
			Date startDate, Date endtDate);
	List<Transaction> GetAllTransactions();
	List<Transaction> GetAccountTransactions(Long _accountid);
	List<Transaction> SelectLastTranscations(Long accountID, int Take);
	List<Transaction> SelectByAccountDateRange(Long accountID, Date startDate,
			Date endDate);
	List<TransactionModel> GetAccountViewStatement(Long AccountID,
			Date _startdate, Date _enddate);
	List<TransactionModel> GetAccountViewTransactionsByDate(int accountId,
			Date startDate, Date endtDate);

	

	// Customer
	Customer CreateCustomer(Customer customer);

	Customer UpdateCustomer(Customer customer);

	List<Customer> GetAllCustomers();

	Customer GetCustomerByEmail(String email);

	Customer GetCustomerByID(Long id);

	//Transaction Type
		TransactionType CreateTransactionType(TransactionType TransactionType);

		TransactionType UpdateTransactionType(TransactionType TransactionType);
		List<TransactionType> GetAllTransactionTypes();

		TransactionType GetTransactionType(Long transactiontypeid);


}
