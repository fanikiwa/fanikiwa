package com.sp.fanikiwa.business;

import com.sp.fanikiwa.entity.AccountType;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.google.api.server.spi.response.CollectionResponse;
import com.google.appengine.api.datastore.Cursor;
import com.google.appengine.datanucleus.query.JDOCursorHelper;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Nullable;
import javax.inject.Named;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;

@Api(name = "accounttypeendpoint", namespace = @ApiNamespace(ownerDomain = "sp.com", ownerName = "sp.com", packagePath = "fanikiwa.entity"))
public class AccountTypeEndpoint {

	/**
	 * This method lists all the entities inserted in datastore.
	 * It uses HTTP GET method and paging support.
	 *
	 * @return A CollectionResponse class containing the list of all entities
	 * persisted and a cursor to the next page.
	 */
	@SuppressWarnings({ "unchecked", "unused" })
	@ApiMethod(name = "listAccountType")
	public CollectionResponse<AccountType> listAccountType(
			@Nullable @Named("cursor") String cursorString,
			@Nullable @Named("limit") Integer limit) {

		PersistenceManager mgr = null;
		Cursor cursor = null;
		List<AccountType> execute = null;

		try {
			mgr = getPersistenceManager();
			Query query = mgr.newQuery(AccountType.class);
			if (cursorString != null && cursorString != "") {
				cursor = Cursor.fromWebSafeString(cursorString);
				HashMap<String, Object> extensionMap = new HashMap<String, Object>();
				extensionMap.put(JDOCursorHelper.CURSOR_EXTENSION, cursor);
				query.setExtensions(extensionMap);
			}

			if (limit != null) {
				query.setRange(0, limit);
			}

			execute = (List<AccountType>) query.execute();
			cursor = JDOCursorHelper.getCursor(execute);
			if (cursor != null)
				cursorString = cursor.toWebSafeString();

			// Tight loop for fetching all entities from datastore and accomodate
			// for lazy fetch.
			for (AccountType obj : execute)
				;
		} finally {
			mgr.close();
		}

		return CollectionResponse.<AccountType> builder().setItems(execute)
				.setNextPageToken(cursorString).build();
	}

	/**
	 * This method gets the entity having primary key id. It uses HTTP GET method.
	 *
	 * @param id the primary key of the java bean.
	 * @return The entity with primary key id.
	 */
	@ApiMethod(name = "getAccountType")
	public AccountType getAccountType(@Named("id") Long id) {
		PersistenceManager mgr = getPersistenceManager();
		AccountType accounttype = null;
		try {
			accounttype = mgr.getObjectById(AccountType.class, id);
		} finally {
			mgr.close();
		}
		return accounttype;
	}

	/**
	 * This inserts a new entity into App Engine datastore. If the entity already
	 * exists in the datastore, an exception is thrown.
	 * It uses HTTP POST method.
	 *
	 * @param accounttype the entity to be inserted.
	 * @return The inserted entity.
	 */
	@ApiMethod(name = "insertAccountType")
	public AccountType insertAccountType(AccountType accounttype) {
		PersistenceManager mgr = getPersistenceManager();
		try {
			if(accounttype.getClass() != null)
			{
			if (containsAccountType(accounttype)) {
				throw new EntityExistsException("Object already exists");
			}
			}
			mgr.makePersistent(accounttype);
		} finally {
			mgr.close();
		}
		return accounttype;
	}

	/**
	 * This method is used for updating an existing entity. If the entity does not
	 * exist in the datastore, an exception is thrown.
	 * It uses HTTP PUT method.
	 *
	 * @param accounttype the entity to be updated.
	 * @return The updated entity.
	 */
	@ApiMethod(name = "updateAccountType")
	public AccountType updateAccountType(AccountType accounttype) {
		PersistenceManager mgr = getPersistenceManager();
		try {
			if (!containsAccountType(accounttype)) {
				throw new EntityNotFoundException("Object does not exist");
			}
			mgr.makePersistent(accounttype);
		} finally {
			mgr.close();
		}
		return accounttype;
	}

	/**
	 * This method removes the entity with primary key id.
	 * It uses HTTP DELETE method.
	 *
	 * @param id the primary key of the entity to be deleted.
	 */
	@ApiMethod(name = "removeAccountType")
	public void removeAccountType(@Named("id") Long id) {
		PersistenceManager mgr = getPersistenceManager();
		try {
			AccountType accounttype = mgr.getObjectById(AccountType.class, id);
			mgr.deletePersistent(accounttype);
		} finally {
			mgr.close();
		}
	}

	private boolean containsAccountType(AccountType accounttype) {
		PersistenceManager mgr = getPersistenceManager();
		boolean contains = true;
		try {
			mgr.getObjectById(AccountType.class, accounttype.getId());
		} catch (javax.jdo.JDOObjectNotFoundException ex) {
			contains = false;
		} finally {
			mgr.close();
		}
		return contains;
	}

	private static PersistenceManager getPersistenceManager() {
		return PMF.get().getPersistenceManager();
	}

	/*
	 * Private members
	 * */
}
