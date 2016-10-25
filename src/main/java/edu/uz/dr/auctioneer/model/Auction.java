package edu.uz.dr.auctioneer.model;

public class Auction {

    private String name;

    public Auction(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Auction{" +
                "name='" + name + '\'' +
                '}';
    }
}
