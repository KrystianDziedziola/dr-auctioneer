package edu.uz.dr.auctioneer.model.request;


import edu.uz.dr.auctioneer.model.auction.Auction;
import edu.uz.dr.auctioneer.model.auction.Currency;
import edu.uz.dr.auctioneer.model.auction.UserInformation;

import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AuctionRequest {

    private static final String DATE_FORMAT = "dd-MM-yyyy HH:mm";

    @Size(min = 1, max = 30,
            message = "Title size has to be between 1 and 30")
    private String title;
    private String description;

    @Min(value = 0,
            message = "Starting price amount can't be less than 0")
    private double startingPriceAmount;

    private String currency;

    private String mainPicturePath;

    @Pattern(regexp = "\\d{2}-\\d{2}-\\d{4} \\d{2}:\\d{2}",
            message = "Date has to match format 'dd-MM-yyyy hh:mm'")
    private String endDate;

    @Size(min = 1, max = 20,
            message = "User name size has to be between 1 and 20")
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

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(final String currency) {
        this.currency = currency;
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
                .setStartingPrice(startingPriceAmount)
                .setCurrency(Currency.valueOf(currency))
                .setMainPicturePath(mainPicturePath)
                .setEndDate(LocalDateTime.parse(endDate, DateTimeFormatter.ofPattern(DATE_FORMAT)))
                .setUserInformation(new UserInformation(user, userDescription))
                .build();
    }
}
