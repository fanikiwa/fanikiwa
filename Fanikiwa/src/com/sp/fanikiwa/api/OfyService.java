package com.sp.fanikiwa.api;

import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyFactory;
import com.googlecode.objectify.ObjectifyService;
import com.sp.fanikiwa.entity.Account;
import com.sp.fanikiwa.entity.AccountType;
import com.sp.fanikiwa.entity.Coa;
import com.sp.fanikiwa.entity.Coadet;
import com.sp.fanikiwa.entity.Customer;
import com.sp.fanikiwa.entity.Member;
import com.sp.fanikiwa.entity.Offer;
import com.sp.fanikiwa.entity.Organization;
import com.sp.fanikiwa.entity.Quote;
import com.sp.fanikiwa.entity.Transaction;
import com.sp.fanikiwa.entity.TransactionType;
import com.sp.fanikiwa.entity.ValueDatedTransaction;
 
/**
 * Objectify service wrapper so we can statically register our persistence classes
 * More on Objectify here : https://code.google.com/p/objectify-appengine/
 *
 */
public class OfyService {
 
static {
 ObjectifyService.register(Quote.class);
 ObjectifyService.register(Organization.class);
 ObjectifyService.register(Customer.class);
 ObjectifyService.register(Transaction.class);
 ObjectifyService.register(TransactionType.class);
 ObjectifyService.register(ValueDatedTransaction.class);
 ObjectifyService.register(Account.class);
 ObjectifyService.register(AccountType.class);
 ObjectifyService.register(Member.class);
 ObjectifyService.register(Coadet.class);
 ObjectifyService.register(Coa.class);
 ObjectifyService.register(Offer.class);
 }
 
public static Objectify ofy() {
 return ObjectifyService.ofy();
 }
 
public static ObjectifyFactory factory() {
 return ObjectifyService.factory();
 }
}