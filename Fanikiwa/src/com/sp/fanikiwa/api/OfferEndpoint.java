package com.sp.fanikiwa.api;

import static com.sp.fanikiwa.api.OfyService.ofy;

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
import com.sp.fanikiwa.entity.Account;
import com.sp.fanikiwa.entity.Member;
import com.sp.fanikiwa.entity.Offer; 
import com.sp.fanikiwa.entity.OfferModel;
import com.sp.fanikiwa.entity.OfferReceipient;
import com.sp.fanikiwa.entity.OfferStatus;

import java.util.ArrayList; 
import java.util.List;

import javax.inject.Named;

@Api(name = "offerendpoint", namespace = @ApiNamespace(ownerDomain = "sp.com", ownerName = "sp.com", packagePath = "fanikiwa.entity"))
public class OfferEndpoint {

	/**
	 * This method lists all the entities inserted in datastore.
	 * It uses HTTP GET method and paging support.
	 *
	 * @return A CollectionResponse class containing the list of all entities
	 * persisted and a cursor to the next page.
	 */
	@SuppressWarnings({ "unchecked", "unused" })
	@ApiMethod(name = "listOffer")
	public CollectionResponse<Offer> listOffer(
			@Nullable @Named("cursor") String cursorString,
			@Nullable @Named("count") Integer count) {

		Query<Offer> query = ofy().load().type(Offer.class);
		if (count != null)
			query.limit(count);
		if (cursorString != null && cursorString != "") {
			query = query.startAt(Cursor.fromWebSafeString(cursorString));
		}

		List<Offer> records = new ArrayList<Offer>();
		QueryResultIterator<Offer> iterator = query.iterator();
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
		return CollectionResponse.<Offer> builder().setItems(records)
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
	@ApiMethod(name = "getOfferByID")
	public Offer getOfferByID(@Named("id") Long id) {
		return findRecord(id);
	}

	/**
	 * This method is used for updating an existing entity. If the entity does
	 * not exist in the datastore, an exception is thrown. It uses HTTP PUT
	 * method.
	 *
	 * @param Offer
	 *            the entity to be updated.
	 * @return The updated entity.
	 * @throws NotFoundException
	 */
	@ApiMethod(name = "updateOffer")
	public Offer updateOffer(Offer Offer) throws NotFoundException {
		Offer record = findRecord(Offer.getId());
		if (record == null) {
			throw new NotFoundException("Record does not exist");
		}
		ofy().save().entities(Offer).now();
		return Offer;
	}

	/**
	 * This method removes the entity with primary key id. It uses HTTP DELETE
	 * method.
	 *
	 * @param id
	 *            the primary key of the entity to be deleted.
	 * @throws NotFoundException
	 */
	@ApiMethod(name = "removeOffer")
	public void removeOffer(@Named("id") Long id) throws NotFoundException {
		Offer record = findRecord(id);
		if (record == null) {
			throw new NotFoundException("Record does not exist");
		}
		ofy().delete().entity(record).now();
	}

	private Offer findRecord(Long id) {
		return ofy().load().type(Offer.class).id(id).now();
	}

	/**
	 * This inserts a new entity into App Engine datastore. If the entity
	 * already exists in the datastore, an exception is thrown. It uses HTTP
	 * POST method.
	 *
	 * @param Offer
	 *            the entity to be inserted.
	 * @return The inserted entity.
	 * @throws ConflictException
	 */
	@ApiMethod(name = "insertOffer")
	public Offer insertOffer(Offer offer) throws NotFoundException,
			ConflictException {
		if (offer.getId() != null) {
			if (findRecord(offer.getId()) != null) {
				throw new ConflictException("Object already exists");
			}
		}
		ofy().save().entities(offer).now();
		return offer;
	}
	
	
	//Non CRUD 
	/*@ApiMethod(name = "CreateLendOffer")
	public Offer CreateLendOffer(Offer offer) throws NotFoundException, ConflictException {
		// Step 1 - Retrieve Member. 
		Member member = offer.getMember();

		// Step 2 - Block funds.
		// calls GLs funds block service.
		AccountEndpoint aep = new AccountEndpoint();
        double availablebalance = member.getCurrentAccount().getClearedBalance() - member.getCurrentAccount().getLimit();
		if (availablebalance < offer .getAmount())
			throw new NotFoundException("Insufficient funds");

		// BlockFunds function checks all account status before the actual block
		aep.BlockFunds(member.getCurrentAccount(), offer.getAmount());

		// Step 2 - Calling Create on Offer.
	    return this.MakeOffer(offer);
	}

	@ApiMethod(name = "BorrowOfferMake")
	public Offer BorrowOfferMake(Offer offer) throws NotFoundException, ConflictException {
		return this.MakeOffer(offer);
	}

	@ApiMethod(name = "SetOfferStatus")
	public void SetOfferStatus(Offer Offer, OfferStatus OfferStatus) {
		Offer offer = findRecord(Offer.getId());
		offer.setStatus(OfferStatus.toString());
		ofy().save().entities(Offer).now();
	}
	 
	@ApiMethod(name = "LendOfferAccept")
	public void LendOfferAccept(Member borrower, Offer offer) {

	}

	@ApiMethod(name = "AcceptBorrowOffer")
	public void AcceptBorrowOffer(Member Lender, Offer offer) {

	}

	@ApiMethod(name = "PartialBorrowOfferAccept")
	public void PartialBorrowOfferAccept(Member Lender, Offer offer) {

	}
	@SuppressWarnings({ "unchecked", "unused" })
	@ApiMethod(name = "OffersListLend")
	public CollectionResponse<Offer> OffersListLend(
			@Nullable @Named("cursor") String cursorString,
			@Nullable @Named("count") Integer count) {

		Query<Offer> query = ofy().load().type(Offer.class);
		if (count != null)
			query.limit(count);
		if (cursorString != null && cursorString != "") {
			query = query.startAt(Cursor.fromWebSafeString(cursorString));
		}

		List<Offer> records = new ArrayList<Offer>();
		QueryResultIterator<Offer> iterator = query.iterator();
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
		return CollectionResponse.<Offer> builder().setItems(records)
				.setNextPageToken(cursorString).build();
	}  
	
	@SuppressWarnings({ "unchecked", "unused" })
	@ApiMethod(name = "MyOffersList")
	public CollectionResponse<Offer> MyOffersList(
			@Nullable @Named("cursor") String cursorString,
			@Nullable @Named("count") Integer count) {

		Query<Offer> query = ofy().load().type(Offer.class);
		if (count != null)
			query.limit(count);
		if (cursorString != null && cursorString != "") {
			query = query.startAt(Cursor.fromWebSafeString(cursorString));
		}

		List<Offer> records = new ArrayList<Offer>();
		QueryResultIterator<Offer> iterator = query.iterator();
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
		return CollectionResponse.<Offer> builder().setItems(records)
				.setNextPageToken(cursorString).build();
	} 
	
	@SuppressWarnings({ "unchecked", "unused" })
	@ApiMethod(name = "RetrieveBorrowOffers")
	public CollectionResponse<Offer> RetrieveBorrowOffers(
			@Nullable @Named("cursor") String cursorString,
			@Nullable @Named("count") Integer count) {

		Query<Offer> query = ofy().load().type(Offer.class);
		if (count != null)
			query.limit(count);
		if (cursorString != null && cursorString != "") {
			query = query.startAt(Cursor.fromWebSafeString(cursorString));
		}

		List<Offer> records = new ArrayList<Offer>();
		QueryResultIterator<Offer> iterator = query.iterator();
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
		return CollectionResponse.<Offer> builder().setItems(records)
				.setNextPageToken(cursorString).build();
	}  
	
	@ApiMethod(name = "DiscardOfferById")
	public void DiscardOfferById(Offer offer)throws NotFoundException {
		//if it is a lend offer, clear the limit first   
        if (offer.getOfferType().equals("L"))
        { 
            Member member =  offer.getMember();

            //reverse the limit
            AccountEndpoint aep = new AccountEndpoint(); 
            aep.UnBlockFunds(member.getCurrentAccount(), offer.getAmount());
        }

        //remove the offer from database 
        this.removeOffer(offer.getId());
	}*/

//	@ApiMethod(name = "GetOfferReceipients")
//	public List<OfferReceipient> GetOfferReceipients(Long Offerid) {
//
//	}

//	@ApiMethod(name = "CreateOfferReceipient")
//	public void CreateOfferReceipient(OfferReceipient offerReceipient) {
//
//	}
//
//	@ApiMethod(name = "GetMemberAccounts")
//	public CollectionResponse<Account> GetMemberAccounts(@Named("MemberId") Long MemberId) {
//		 
//		Member member = GetMember(MemberId);
//
//		List<Account> memberAccounts = new ArrayList<Account>();
//		memberAccounts.add(member.getCurrentAccount());
//		memberAccounts.add(member.getLoanAccount());
//		memberAccounts.add(member.getInvestmentAccount());
//
//		return memberAccounts;
//	}

//	@ApiMethod(name = "ListMyLoans")
//	public List<STO> ListMyLoans(Long MemberId) {
//
//	}
//
//	@ApiMethod(name = "ListMyInvestments")
//	public List<STO> ListMyInvestments(Long MemberId) {
//
//	}
	
	 
	private Offer MakeOffer(Offer offer) throws NotFoundException, ConflictException {
        return insertOffer(offer);
		
	}
		
	private Member SearchMember(Long MemberId) {
	MemberEndpoint mep = new MemberEndpoint();
	Member member = mep.getMemberByID(MemberId);
	return  member;
}
 
}
