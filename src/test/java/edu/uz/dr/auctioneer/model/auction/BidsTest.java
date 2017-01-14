package edu.uz.dr.auctioneer.model.auction;

import edu.uz.dr.auctioneer.model.auction.error.TooSmallBidValueException;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.assertj.core.api.ThrowableAssert.catchThrowable;

public class BidsTest {

    private Bids bids;
    private Bid bid;
    private UserInformation userInformation;

    @Before
    public void Set_Up() {
        bids = new Bids();
        bid = new Bid(100, "user");
    }

    @Test
    public void Should_Add_Bid_If_Bids_List_Is_Empty() {
        // given

        // when
        bids.addBid(bid);

        // then
        assertThat(bids.getNumberOfBids()).isEqualTo(1);
    }

    @Test
    public void Should_Add_Bid_If_It_Is_The_Highest() {
        // given
        bids.addBid(bid);

        final Bid higherBid = new Bid(150, "user1");

        // when
        bids.addBid(higherBid);

        // then
        assertThat(bids.getNumberOfBids()).isEqualTo(2);
    }

    @Test
    public void Should_Throw_Exception_If_Bid_Is_Not_The_Highest() {
        // given
        bids.addBid(bid);

        // when
        final Throwable result = catchThrowable(() -> bids.addBid(bid));

        // then
        assertThat(result).isInstanceOf(TooSmallBidValueException.class);
    }
}