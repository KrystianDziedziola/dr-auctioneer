package edu.uz.dr.auctioneer.model.auction.error;

import java.time.LocalDateTime;

public class AuctionFinishedException extends Exception {

    public AuctionFinishedException(final String title, final LocalDateTime endDate) {
        super(String.format("Auction '%s' has already finished on %s.", title, endDate));
    }
}
