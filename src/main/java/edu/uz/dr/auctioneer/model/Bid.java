package edu.uz.dr.auctioneer.model;

import java.time.LocalDateTime;

public class Bid {

    private final Money money;
    private final User user;
    private final LocalDateTime dateTime;

    Bid(final Money money, final User user) {
        this.money = money;
        this.user = user;
        this.dateTime = LocalDateTime.now();
    }

    public double getAmount() {
        return getMoney().getAmount();
    }

    Money getMoney() {
        return money;
    }
}