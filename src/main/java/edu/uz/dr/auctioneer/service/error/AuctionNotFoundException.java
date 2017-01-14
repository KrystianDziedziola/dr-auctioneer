package edu.uz.dr.auctioneer.service.error;

public class AuctionNotFoundException extends RuntimeException {

    public AuctionNotFoundException() {
        super("Auction not found");
    }
}
