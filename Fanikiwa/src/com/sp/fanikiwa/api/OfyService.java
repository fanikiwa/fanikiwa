package com.sp.fanikiwa.api;

import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyFactory;
import com.googlecode.objectify.ObjectifyService;
import com.sp.fanikiwa.entity.Customer;
import com.sp.fanikiwa.entity.Organization;
import com.sp.fanikiwa.entity.Quote;
 
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
 }
 
public static Objectify ofy() {
 return ObjectifyService.ofy();
 }
 
public static ObjectifyFactory factory() {
 return ObjectifyService.factory();
 }
}