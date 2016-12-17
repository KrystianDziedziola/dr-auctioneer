package edu.uz.dr.auctioneer.model.auction;

import org.springframework.data.annotation.Id;
import org.springframework.util.Assert;

import java.time.LocalDateTime;

public class Auction {

    @Id
    private final String title;
    private final String description;
    private final Money startingPrice;
    private final String mainPicturePath;
    private final Bids bids;
    private final LocalDateTime startDate;
    private final LocalDateTime endDate;
    private final UserInformation userInformation;
    private boolean isFinished;

    Auction(final String title, final String description, final Money startingPrice, final String mainPicturePath,
            final LocalDateTime startDate, final LocalDateTime endDate, final UserInformation userInformation) {
        this.title = title;
        this.description = description;
        this.startingPrice = startingPrice;
        this.mainPicturePath = mainPicturePath;
        this.bids = new Bids(startingPrice.getCurrency());
        this.startDate = startDate;
        this.endDate = endDate;
        this.userInformation = userInformation;
        this.isFinished = false;

        addStartingPriceToBids();
    }

    public void addBid(final Bid bid) {
        bids.addBid(bid);
    }

    public void addBid(final double amount, final String username) {
        bids.addBid(amount, username);
    }

    public int getNumberOfBids() {
        return bids.getNumberOfBids();
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Money getStartingPrice() {
        return startingPrice;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public UserInformation getUserInformation() {
        return userInformation;
    }

    public Bids getBids() {
        return bids;
    }

    public void setFinished(final boolean isFinished) {
        this.isFinished = isFinished;
    }

    private void addStartingPriceToBids() {
        final String startingPriceUser = String.format("%s - Starting price", userInformation.getLogin());
        final Bid startingPriceBid = new Bid(startingPrice, startingPriceUser);
        bids.addBid(startingPriceBid);
    }

    public static class Builder {

        private static final String STARTING_PRICE_REQUIRED_MESSAGE = "Starting price is required";
        private static final String TITLE_REQUIRED_MESSAGE = "Title is required";
        private static final String WRONG_END_DATE_MESSAGE = "End date should be after current date";
        private static final String USER_INFORMATION_REQUIRED_MESSAGE = "User information is required";

        private String title;
        private String description;
        private Money startingPrice;
        private String mainPicturePath;
        private LocalDateTime endDate;
        private final LocalDateTime startDate = LocalDateTime.now();
        private UserInformation userInformation;

        public Builder setTitle(final String title) {
            this.title = title;
            return this;
        }

        public Builder setDescription(final String description) {
            this.description = description;
            return this;
        }

        public Builder setStartingPrice(final double amount, final Currency currency) {
            this.startingPrice = new Money(amount, currency);
            return this;
        }

        public Builder setMainPicturePath(final String path) {
            this.mainPicturePath = path;
            return this;
        }

        public Builder setEndDate(final LocalDateTime date) {
            this.endDate = date;
            return this;
        }

        public Builder setUserInformation(final UserInformation userInformation) {
            this.userInformation = userInformation;
            return this;
        }

        public Auction build() {
            validateParameters();
            return new Auction(title, description, startingPrice, mainPicturePath, startDate, endDate, userInformation);
        }

        private void validateParameters() {
            Assert.hasText(title, TITLE_REQUIRED_MESSAGE);
            Assert.notNull(startingPrice, STARTING_PRICE_REQUIRED_MESSAGE);
            Assert.notNull(endDate, WRONG_END_DATE_MESSAGE);
            Assert.notNull(userInformation, USER_INFORMATION_REQUIRED_MESSAGE);

            if (endDate.isBefore(startDate)) {
                throw new IllegalArgumentException(WRONG_END_DATE_MESSAGE);
            }
        }
    }
}
