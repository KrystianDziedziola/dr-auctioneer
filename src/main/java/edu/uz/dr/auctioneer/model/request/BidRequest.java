package edu.uz.dr.auctioneer.model.request;

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
}
