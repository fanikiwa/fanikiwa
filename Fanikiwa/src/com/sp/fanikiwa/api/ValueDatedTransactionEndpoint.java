package com.sp.fanikiwa.api;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.google.api.server.spi.config.Nullable;
import com.google.api.server.spi.response.CollectionResponse;
import com.google.api.server.spi.response.ConflictException;
import com.google.api.server.spi.response.NotFoundException;
import com.google.appengine.api.datastore.Cursor;
import com.google.appengine.api.datastore.QueryResultIterator;
import com.googlecode.objectify.cmd.Query;

import static com.sp.fanikiwa.api.OfyService.ofy;

import com.sp.fanikiwa.entity.ValueDatedTransaction;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.inject.Named;

@Api(name = "valuedatedtransactionendpoint", namespace = @ApiNamespace(ownerDomain = "sp.com", ownerName = "sp.com", packagePath = "fanikiwa.entity"))
public class ValueDatedTransactionEndpoint {

	/**
	 * This method lists all the entities inserted in datastore.
	 * It uses HTTP GET method and paging support.
	 *
	 * @return A CollectionResponse class containing the list of all entities
	 * persisted and a cursor to the next page.
	 */
	@SuppressWarnings({ "unchecked", "unused" })
	@ApiMethod(name = "listValueDatedTransaction")
	public CollectionResponse<ValueDatedTransaction> listValueDatedTransaction(
			@Nullable @Named("cursor") String cursorString,
			@Nullable @Named("count") Integer count) {

			Query<ValueDatedTransaction> query = ofy().load().type(ValueDatedTransaction.class);
			if (count != null)
				query.limit(count);
			if (cursorString != null && cursorString != "") {
				query = query.startAt(Cursor.fromWebSafeString(cursorString));
			}

			List<ValueDatedTransaction> records = new ArrayList<ValueDatedTransaction>();
			QueryResultIterator<ValueDatedTransaction> iterator = query.iterator();
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
			return CollectionResponse.<ValueDatedTransaction> builder().setItems(records)
					.setNextPageToken(cursorString).build();
		}

	/**
	 * This method gets the entity having primary key id. It uses HTTP GET method.
	 *
	 * @param id the primary key of the java bean.
	 * @return The entity with primary key id.
	 */
	@ApiMethod(name = "getValueDatedTransaction")
	public ValueDatedTransaction getValueDatedTransaction(@Named("id") Long id) {
		return findRecord(id);
	}

	/**
	 * This inserts a new entity into App Engine datastore. If the entity already
	 * exists in the datastore, an exception is thrown.
	 * It uses HTTP POST method.
	 *
	 * @param valuedatedtransaction the entity to be inserted.
	 * @return The inserted entity.
	 * @throws ConflictException 
	 */
	@ApiMethod(name = "insertValueDatedTransaction")
	public ValueDatedTransaction insertValueDatedTransaction(
			ValueDatedTransaction valuedatedtransaction) throws ConflictException {
		if (valuedatedtransaction.getTransactionID() != null) {
			if (findRecord(valuedatedtransaction.getTransactionID()) != null) {
				throw new ConflictException("Object already exists");
			}
		}
		ofy().save().entities(valuedatedtransaction).now();
		return valuedatedtransaction;
	}

	/**
	 * This method is used for updating an existing entity. If the entity does not
	 * exist in the datastore, an exception is thrown.
	 * It uses HTTP PUT method.
	 *
	 * @param valuedatedtransaction the entity to be updated.
	 * @return The updated entity.
	 * @throws NotFoundException 
	 */
	@ApiMethod(name = "updateValueDatedTransaction")
	public ValueDatedTransaction updateValueDatedTransaction(
			ValueDatedTransaction valuedatedtransaction) throws NotFoundException {
		ValueDatedTransaction record = findRecord(valuedatedtransaction.getTransactionID());
		if (record == null) {
			throw new NotFoundException("Record does not exist");
		}
		ofy().save().entities(valuedatedtransaction).now();
		return valuedatedtransaction;
	}

	/**
	 * This method removes the entity with primary key id.
	 * It uses HTTP DELETE method.
	 *
	 * @param id the primary key of the entity to be deleted.
	 * @throws NotFoundException 
	 */
	@ApiMethod(name = "removeValueDatedTransaction")
	public void removeValueDatedTransaction(@Named("id") Long id) throws NotFoundException {
		ValueDatedTransaction record = findRecord(id);
		if (record == null) {
			throw new NotFoundException("Record does not exist");
		}
		ofy().delete().entity(record).now();
	}
	

	private ValueDatedTransaction findRecord(Long id) {
		return ofy().load().type(ValueDatedTransaction.class).id(id).now();
	}

}
