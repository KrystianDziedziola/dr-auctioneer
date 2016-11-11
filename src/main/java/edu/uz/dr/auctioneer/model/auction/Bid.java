package edu.uz.dr.auctioneer.model.auction;

import java.time.LocalDateTime;

public class Bid {

    private final Money money;
    private final UserInformation userInformation;
    private final LocalDateTime dateTime;

    Bid(final Money money, final UserInformation userInformation) {
        this.money = money;
        this.userInformation = userInformation;
        this.dateTime = LocalDateTime.now();
    }

    public double getAmount() {
        return getMoney().getAmount();
    }

    Money getMoney() {
        return money;
    }
}