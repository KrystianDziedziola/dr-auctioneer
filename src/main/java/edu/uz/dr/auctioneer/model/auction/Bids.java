package edu.uz.dr.auctioneer.model.auction;

import com.google.common.collect.Iterables;
import edu.uz.dr.auctioneer.model.auction.error.TooSmallBidValueException;

import java.util.ArrayList;
import java.util.List;

public class Bids {

    private final List<Bid> bids = new ArrayList<>();
    private final Currency currency;

    public Bids(final Currency currency) {
        this.currency = currency;
    }

    public List<Bid> getBids() {
        return bids;
    }

    void addBid(final Bid bid) {
        if (bids.isEmpty()) {
            bids.add(bid);
        } else {
            final Bid highestBid = Iterables.getLast(bids);
            final Money highestBidMoney = highestBid.getMoney();
            final Money bidMoney = bid.getMoney();

            if (bidMoney.isBiggerThan(highestBidMoney)) {
                bids.add(bid);
            } else {
                throw new TooSmallBidValueException(bid, highestBid);
            }
        }
    }

    void addBid(final double amount, final String username) {
        final Money money = new Money(amount, currency);
        final Bid bid = new Bid(money, username);
        addBid(bid);
    }

    public Currency getCurrency() {
        return currency;
    }

    int getNumberOfBids() {
        return bids.size();
    }
}
