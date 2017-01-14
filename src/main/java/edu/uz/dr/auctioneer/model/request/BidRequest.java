package edu.uz.dr.auctioneer.model.request;

public class BidRequest {

    private String username;
    private Double amount;

    public String getUsername() {
        return username;
    }

    public void setUsername(final String username) {
        this.username = username;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(final Double amount) {
        this.amount = amount;
    }
}
