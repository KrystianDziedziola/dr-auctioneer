package edu.uz.dr.auctioneer.model.error;

import edu.uz.dr.auctioneer.model.Bid;

public class TooSmallBidValueException extends RuntimeException {

    public TooSmallBidValueException(final Bid bid, final Bid highestBid) {
        super(String.format("Your bid value is: %f, but it has to be more than the highest bid: %f",
                bid.getAmount(), highestBid.getAmount()));
    }
}
