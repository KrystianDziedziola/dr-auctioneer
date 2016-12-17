package edu.uz.dr.auctioneer.model.auction;

import java.time.LocalDateTime;

public class Bid {

    private final Money money;
    private final String user;
    private final LocalDateTime dateTime;

    public Bid(final Money money, final String user) {
        this.money = money;
        this.user = user;
        this.dateTime = LocalDateTime.now();
    }

    public Money getMoney() {
        return money;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public String getUser() {
        return user;
    }

    public double getAmount() {
        return getMoney().getAmount();
    }
}