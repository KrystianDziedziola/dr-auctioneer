package edu.uz.dr.auctioneer.model;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class Auction {

    private final String title;
    private final String description;
    private final String mainPicturePath;
    private final Bids bids;
    private final LocalDateTime startDate;
    private final LocalDateTime endDate;
    private final User user;
    private boolean isFinished;

    Auction(final String title, final String description, final String mainPicturePath,
            final LocalDateTime endDate, final User user) {
        this.title = title;
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

        private String title;
        private String description;
        private String mainPicturePath;
        private LocalDateTime endDate;
        private User user;

        public Builder setTitle(final String title) {
            this.title = title;
            return this;
        }

        public Builder setDescription(final String description) {
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

        public Builder setUser(final User user) {
            this.user = user;
            return this;
        }

        public Auction build() {
//            TODO:validate parameters here
            return new Auction(title, description, mainPicturePath, endDate, user);
        }
    }
}
