package com.sp.fanikiwa.api;

import com.sp.fanikiwa.entity.EMF;
import com.sp.fanikiwa.entity.TransactionType;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.google.api.server.spi.response.CollectionResponse;
import com.google.appengine.api.datastore.Cursor;
import com.google.appengine.datanucleus.query.JPACursorHelper;

import java.util.List;

import javax.annotation.Nullable;
import javax.inject.Named;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import javax.persistence.EntityManager;
import javax.persistence.Query;

@Api(name = "transactiontypeendpoint", namespace = @ApiNamespace(ownerDomain = "sp.com", ownerName = "sp.com", packagePath = "fanikiwa.entity"))
public class TransactionTypeEndpoint {

	/**
	 * This method lists all the entities inserted in datastore.
	 * It uses HTTP GET method and paging support.
	 *
	 * @return A CollectionResponse class containing the list of all entities
	 * persisted and a cursor to the next page.
	 */
	@SuppressWarnings({ "unchecked", "unused" })
	@ApiMethod(name = "listTransactionType")
	public CollectionResponse<TransactionType> listTransactionType(
			@Nullable @Named("cursor") String cursorString,
			@Nullable @Named("limit") Integer limit) {

		EntityManager mgr = null;
		Cursor cursor = null;
		List<TransactionType> execute = null;

		try {
			mgr = getEntityManager();
			Query query = mgr
					.createQuery("select from TransactionType as TransactionType");
			if (cursorString != null && cursorString != "") {
				cursor = Cursor.fromWebSafeString(cursorString);
				query.setHint(JPACursorHelper.CURSOR_HINT, cursor);
			}

			if (limit != null) {
				query.setFirstResult(0);
				query.setMaxResults(limit);
			}

			execute = (List<TransactionType>) query.getResultList();
			cursor = JPACursorHelper.getCursor(execute);
			if (cursor != null)
				cursorString = cursor.toWebSafeString();

			// Tight loop for fetching all entities from datastore and accomodate
			// for lazy fetch.
			for (TransactionType obj : execute)
				;
		} finally {
			mgr.close();
		}

		return CollectionResponse.<TransactionType> builder().setItems(execute)
				.setNextPageToken(cursorString).build();
	}

	/**
	 * This method gets the entity having primary key id. It uses HTTP GET method.
	 *
	 * @param id the primary key of the java bean.
	 * @return The entity with primary key id.
	 */
	@ApiMethod(name = "getTransactionType")
	public TransactionType getTransactionType(@Named("id") Long id) {
		EntityManager mgr = getEntityManager();
		TransactionType transactiontype = null;
		try {
			transactiontype = mgr.find(TransactionType.class, id);
		} finally {
			mgr.close();
		}
		return transactiontype;
	}

	/**
	 * This inserts a new entity into App Engine datastore. If the entity already
	 * exists in the datastore, an exception is thrown.
	 * It uses HTTP POST method.
	 *
	 * @param transactiontype the entity to be inserted.
	 * @return The inserted entity.
	 */
	@ApiMethod(name = "insertTransactionType")
	public TransactionType insertTransactionType(TransactionType transactiontype) {
		EntityManager mgr = getEntityManager();
		try {
			if (containsTransactionType(transactiontype)) {
				throw new EntityExistsException("Object already exists");
			}
			mgr.persist(transactiontype);
		} finally {
			mgr.close();
		}
		return transactiontype;
	}

	/**
	 * This method is used for updating an existing entity. If the entity does not
	 * exist in the datastore, an exception is thrown.
	 * It uses HTTP PUT method.
	 *
	 * @param transactiontype the entity to be updated.
	 * @return The updated entity.
	 */
	@ApiMethod(name = "updateTransactionType")
	public TransactionType updateTransactionType(TransactionType transactiontype) {
		EntityManager mgr = getEntityManager();
		try {
			if (!containsTransactionType(transactiontype)) {
				throw new EntityNotFoundException("Object does not exist");
			}
			mgr.persist(transactiontype);
		} finally {
			mgr.close();
		}
		return transactiontype;
	}

	/**
	 * This method removes the entity with primary key id.
	 * It uses HTTP DELETE method.
	 *
	 * @param id the primary key of the entity to be deleted.
	 */
	@ApiMethod(name = "removeTransactionType")
	public void removeTransactionType(@Named("id") Long id) {
		EntityManager mgr = getEntityManager();
		try {
			TransactionType transactiontype = mgr.find(TransactionType.class,
					id);
			mgr.remove(transactiontype);
		} finally {
			mgr.close();
		}
	}

	private boolean containsTransactionType(TransactionType transactiontype) {
		EntityManager mgr = getEntityManager();
		boolean contains = true;
		try {
			TransactionType item = mgr.find(TransactionType.class,
					transactiontype.getTransactionTypeID());
			if (item == null) {
				contains = false;
			}
		} finally {
			mgr.close();
		}
		return contains;
	}

	private static EntityManager getEntityManager() {
		return EMF.get().createEntityManager();
	}

}
