package edu.uz.dr.auctioneer.model.request;

import edu.uz.dr.auctioneer.model.auction.Bid;
import edu.uz.dr.auctioneer.model.auction.Currency;
import edu.uz.dr.auctioneer.model.auction.Money;

public class BidRequest {

    private String username;
    private double amount;

    public BidRequest() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(final String username) {
        this.username = username;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(final double amount) {
        this.amount = amount;
    }

    public Bid buildBid() {
        final Money money = new Money(amount, Currency.PLN);
        return new Bid(money, username);
    }
}
