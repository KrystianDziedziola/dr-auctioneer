package edu.uz.dr.auctioneer.model.auction.error;

import edu.uz.dr.auctioneer.model.auction.Bid;

public class TooSmallBidValueException extends RuntimeException {

    public TooSmallBidValueException(final Bid bid, final Bid highestBid) {
        super(String.format("Your bid value is: %f, but it has to be more than the highest bid: %f",
                bid.getPrice(), highestBid.getPrice()));
    }
}
