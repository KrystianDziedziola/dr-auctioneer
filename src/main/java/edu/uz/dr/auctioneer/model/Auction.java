package edu.uz.dr.auctioneer.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Auction {

    private final String name;
    private final String description;
    private final String mainPicturePath;
    private final List<Bid> bids;
    private final LocalDateTime startDate;
    private final LocalDateTime endDate;
    private final OwnerInfo ownerInfo;
    private boolean isFinished;

    private Auction(final String name, final String description, final String mainPicturePath,
                    final LocalDateTime endDate, final OwnerInfo ownerInfo) {
        this.name = name;
        this.description = description;
        this.mainPicturePath = mainPicturePath;
        this.bids = new ArrayList<>();
        this.startDate = LocalDateTime.now();
        this.endDate = endDate;
        this.ownerInfo = ownerInfo;
        this.isFinished = false;
    }

    public void addBid(final Bid bid) {
//          final Bid highestBid = Iterables.getLast(bids);
//          add bid if is the highest
        bids.add(bid);
    }

    public void setFinished(final boolean isFinished) {
        this.isFinished = isFinished;
    }

    public static class Builder {

        private String name;
        private String description;
        private String mainPicturePath;
        private LocalDateTime endDate;
        private OwnerInfo ownerInfo;

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

        public Builder setOwnerInfo(final OwnerInfo info) {
            this.ownerInfo = info;
            return this;
        }

        public Auction build() {
            return new Auction(name, description, mainPicturePath, endDate, ownerInfo);
        }
    }
}
