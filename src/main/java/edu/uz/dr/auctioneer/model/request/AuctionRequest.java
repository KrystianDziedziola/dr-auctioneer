package edu.uz.dr.auctioneer.model.request;


import edu.uz.dr.auctioneer.model.auction.Auction;
import edu.uz.dr.auctioneer.model.auction.Currency;
import edu.uz.dr.auctioneer.model.auction.UserInformation;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AuctionRequest {

    private static final String DATE_FORMAT = "dd-MM-yyyy HH:mm";

    private String title;
    private String description;
    private double startingPriceAmount;
    private String startingPriceCurrency;
    private String mainPicturePath;
    private String endDate;
    private String user;
    private String userDescription;

    public String getTitle() {
        return title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public double getStartingPriceAmount() {
        return startingPriceAmount;
    }

    public void setStartingPriceAmount(final double startingPriceAmount) {
        this.startingPriceAmount = startingPriceAmount;
    }

    public String getStartingPriceCurrency() {
        return startingPriceCurrency;
    }

    public void setStartingPriceCurrency(final String startingPriceCurrency) {
        this.startingPriceCurrency = startingPriceCurrency;
    }

    public String getMainPicturePath() {
        return mainPicturePath;
    }

    public void setMainPicturePath(final String mainPicturePath) {
        this.mainPicturePath = mainPicturePath;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(final String endDate) {
        this.endDate = endDate;
    }

    public String getUser() {
        return user;
    }

    public void setUser(final String user) {
        this.user = user;
    }

    public String getUserDescription() {
        return userDescription;
    }

    public void setUserDescription(final String userDescription) {
        this.userDescription = userDescription;
    }

    public Auction buildAuction() {
        return new Auction.Builder()
                .setTitle(title)
                .setDescription(description)
                .setStartingPrice(startingPriceAmount, Currency.valueOf(startingPriceCurrency))
                .setMainPicturePath(mainPicturePath)
                .setEndDate(LocalDateTime.parse(endDate, DateTimeFormatter.ofPattern(DATE_FORMAT)))
                .setUserInformation(new UserInformation(user, userDescription))
                .build();
    }
}
