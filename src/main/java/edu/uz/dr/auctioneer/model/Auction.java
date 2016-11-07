package edu.uz.dr.auctioneer.model;

import java.time.LocalDateTime;

public class Auction {

    private final String name;
    private final String description;
    private final String mainPicturePath;
    private final Bids bids;
    private final LocalDateTime startDate;
    private final LocalDateTime endDate;
    private final User user;
    private boolean isFinished;

    //TODO: ma być private
    public Auction(final String name, final String description, final String mainPicturePath,
                   final LocalDateTime endDate, final User user) {
        this.name = name;
        this.description = description;
        this.mainPicturePath = mainPicturePath;
        this.bids = new Bids();
        this.startDate = LocalDateTime.now();
        this.endDate = endDate;
        this.user = user;
        this.isFinished = false;
    }

    public void addBid(final Bid bid) {
        bids.addBid(bid);
    }

    public void setFinished(final boolean isFinished) {
        this.isFinished = isFinished;
    }

    public static class Builder {

        private String name;
        private String description;
        private String mainPicturePath;
        private LocalDateTime endDate;
        private User user;

        public Builder setName(final String name) {
            this.name = name;
            return this;
        }

        public Builder setDesctiption(final String description) {
            this.description = description;
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

        public Builder setOwnerInfo(final User user) {
            this.user = user;
            return this;
        }

        public Auction build() {
            //TODO: validacja czy są wszystkie pola
            return new Auction(name, description, mainPicturePath, endDate, user);
        }
    }
}
