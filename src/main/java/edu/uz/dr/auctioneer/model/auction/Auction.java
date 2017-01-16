package edu.uz.dr.auctioneer.model.auction;

import edu.uz.dr.auctioneer.model.auction.error.AuctionFinishedException;
import org.springframework.data.annotation.Id;
import org.springframework.util.Assert;

import java.time.LocalDateTime;

public class Auction {

    @Id
    private final String title;
    private final String description;
    private final double startingPrice;
    private final Currency currency;
    private final String mainPicturePath;
    private final Bids bids;
    private final LocalDateTime startDate;
    private final LocalDateTime endDate;
    private final UserInformation userInformation;
    private final String password;

    Auction(final String title, final String description, final double startingPrice, final Currency currency,
            final String mainPicturePath, final LocalDateTime startDate, final LocalDateTime endDate,
            final UserInformation userInformation, final String password) {
        this.title = title;
        this.description = description;
        this.startingPrice = startingPrice;
        this.currency = currency;
        this.mainPicturePath = mainPicturePath;
        this.bids = new Bids();
        this.startDate = startDate;
        this.endDate = endDate;
        this.userInformation = userInformation;
        this.password = password;

        addStartingPriceToBids();
    }

    public void addBid(final double amount, final String username) throws AuctionFinishedException {
        if (getFinished()) {
            throw new AuctionFinishedException(title, endDate);
        }
        final Bid bid = new Bid(amount, username);
        bids.addBid(bid);
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public double getStartingPrice() {
        return startingPrice;
    }

    public Currency getCurrency() {
        return currency;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public UserInformation getUserInformation() {
        return userInformation;
    }

    public String getMainPicturePath() {
        return mainPicturePath;
    }

    public double getCurrentPrice() {
        final Bid highestBid = bids.getHighestBid();
        return highestBid.getPrice();
    }

    public Bids getBids() {
        return bids;
    }

    public String getPassword() {
        return password;
    }

    public boolean getFinished() {
        final LocalDateTime now = LocalDateTime.now();
        return now.isAfter(endDate);
    }

    int getNumberOfBids() {
        return bids.getNumberOfBids();
    }

    private void addStartingPriceToBids() {
        final String startingPriceUser = String.format("%s - Starting price", userInformation.getLogin());
        final Bid startingPriceBid = new Bid(startingPrice, startingPriceUser);
        bids.addBid(startingPriceBid);
    }

    public static class Builder {

        private static final String CURRENCY_REQUIRED_MESSAGE = "Currency is required";
        private static final String TITLE_REQUIRED_MESSAGE = "Title is required";
        private static final String WRONG_END_DATE_MESSAGE = "End date should be after current date";
        private static final String USER_INFORMATION_REQUIRED_MESSAGE = "User information is required";
        private static final String WRONG_STARTING_PRICE_MESSAGE = "Starting price shouldn't be less than 0";

        private String title;
        private String description;
        private double startingPrice;
        private Currency currency;
        private String mainPicturePath;
        private LocalDateTime endDate;
        private final LocalDateTime startDate = LocalDateTime.now();
        private UserInformation userInformation;
        private String password;

        public Builder setTitle(final String title) {
            this.title = title;
            return this;
        }

        public Builder setDescription(final String description) {
            this.description = description;
            return this;
        }

        public Builder setStartingPrice(final double startingPrice) {
            this.startingPrice = startingPrice;
            return this;
        }

        public Builder setCurrency(final Currency currency) {
            this.currency = currency;
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

        public Builder setPassword(final String password) {
            this.password = password;
            return this;
        }

        public Auction build() {
            validateParameters();
            return new Auction(title, description, startingPrice, currency, mainPicturePath,
                    startDate, endDate, userInformation, password);
        }

        private void validateParameters() {
            Assert.hasText(title, TITLE_REQUIRED_MESSAGE);
            Assert.notNull(currency, CURRENCY_REQUIRED_MESSAGE);
            Assert.notNull(endDate, WRONG_END_DATE_MESSAGE);
            Assert.notNull(userInformation, USER_INFORMATION_REQUIRED_MESSAGE);

            if (startingPrice < 0) {
                throw new IllegalArgumentException(WRONG_STARTING_PRICE_MESSAGE);
            }

            if (endDate.isBefore(startDate)) {
                throw new IllegalArgumentException(WRONG_END_DATE_MESSAGE);
            }
        }
    }
}
