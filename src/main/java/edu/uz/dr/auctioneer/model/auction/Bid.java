package edu.uz.dr.auctioneer.model.auction;

import java.time.LocalDateTime;

public class Bid {

    private final double price;
    private final String user;
    private final LocalDateTime dateTime;

    public Bid(final double price, final String user) {
        this.price = price;
        this.user = user;
        this.dateTime = LocalDateTime.now();
    }

    public double getPrice() {
        return price;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public String getUser() {
        return user;
    }
}