package com.sp.fanikiwa.business;

import java.util.List;

import com.sp.fanikiwa.entity.Account;
import com.sp.fanikiwa.entity.Member;
import com.sp.fanikiwa.entity.Offer;
import com.sp.fanikiwa.entity.OfferModel;
import com.sp.fanikiwa.entity.OfferReceipient;
import com.sp.fanikiwa.entity.OfferStatus;
import com.sp.fanikiwa.entity.STO;

public interface IPeerLending {
	//Member
		Member GetMemberByEmail(String email);
		Member GetMemberByID(Long MemberId);
		Member Register(Member member);
		void UpdateMember(Member member);
		void DeRegister(Member member);

		//Peerlending
		List<Offer> ListLendOffers(Member member);
		List<Offer> ListMyOffers(Member member);
		List<Offer> ListBorrowOffers(Member member);
		Offer GetOfferById(Long id);
		void AcceptLendOffer(Member borrower, Offer offer);
		void AcceptBorrowOffer(Member Lender, Offer offer);
		void AcceptPartialBorrowOffer(Member Lender, Offer offer);
		Offer MakeLendOffer(OfferModel offerModel);
		Offer MakeBorrowOffer(OfferModel offerModel);
		void SetOfferStatus(Offer offer, OfferStatus OfferStatus);
		void DeleteOfferById(Offer offer);
		List<OfferReceipient>  GetOfferReceipients(Long Offerid);
		void CreateOfferReceipient(OfferReceipient offerReceipient);
		List<Account> GetMemberAccounts(Long MemberId);
		List<STO> ListMyLoans(Long MemberId);
		List<STO> ListMyInvestments(Long MemberId);
}
