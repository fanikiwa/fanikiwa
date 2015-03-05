package com.sp.fanikiwa.business;

import com.google.api.server.spi.response.CollectionResponse;
import com.sp.fanikiwa.entity.Account;
import com.sp.fanikiwa.entity.AccountLimitStatus;
import com.sp.fanikiwa.entity.PassFlag;

public interface IAccount {
	// Accounts
		double getAvailableBalance(Long accountid);
		double GetAccountLimitAmount(Long accountid);

		void BlockFunds(Account account, double amount);

		void ClearEffects(Account account, double amount);

		void CloseAccount(Account account);

		Account getAccount(Long accountID);
		AccountLimitStatus GetAccountLimitStatus(Account act);

		PassFlag GetAccountLockStatus(Account act);

		Account insertAccount(Account account);

		void SetAccountLimitStatus(Account acc, AccountLimitStatus status);

		void SetAccountLockStatus(Account acc, PassFlag status);

		void UnBlockFunds(Account account, double amount);

		Account updateAccount(Account account);

		CollectionResponse<Account> listAccount(String cursor, Integer limit);

		boolean IsAccountClosed(Long accountid);
		boolean getAccountExists(Long account);

}
