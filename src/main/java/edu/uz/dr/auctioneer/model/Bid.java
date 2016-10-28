package edu.uz.dr.auctioneer.model;

import java.time.LocalDateTime;

public class Bid {

    private int amount;
    private User user;
    private LocalDateTime dateTime;

    public int getAmount() {
        return amount;
    }
}
