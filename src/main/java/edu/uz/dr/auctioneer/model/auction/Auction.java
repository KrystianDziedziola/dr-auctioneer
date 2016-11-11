package edu.uz.dr.auctioneer.model.auction;

import java.time.LocalDateTime;

public class Auction {

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
            final LocalDateTime endDate, final UserInformation userInformation) {
        this.title = title;
        this.description = description;
        this.startingPrice = startingPrice;
        this.mainPicturePath = mainPicturePath;
        this.bids = new Bids();
        this.startDate = LocalDateTime.now();
        this.endDate = endDate;
        this.userInformation = userInformation;
        this.isFinished = false;

        bids.addBid(new Bid(startingPrice, userInformation));
    }

    public void addBid(final Bid bid) {
        bids.addBid(bid);
    }

    public int getNumberOfBids() {
        return bids.getNumberOfBids();
    }

    public void setFinished(final boolean isFinished) {
        this.isFinished = isFinished;
    }

    public static class Builder {

        private String title;
        private String description;
        private Money startingPrice;
        private String mainPicturePath;
        private LocalDateTime endDate;
        private UserInformation userInformation;

        public Builder setTitle(final String title) {
            this.title = title;
            return this;
        }

        public Builder setDescription(final String description) {
            this.description = description;
            return this;
        }

        public Builder setStartingPrice(final Money startingPrice) {
            this.startingPrice = startingPrice;
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
//            TODO:validate parameters here
            return new Auction(title, description, startingPrice, mainPicturePath, endDate, userInformation);
        }
    }
}
