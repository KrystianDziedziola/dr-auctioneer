package edu.uz.dr.auctioneer.model;

import edu.uz.dr.auctioneer.model.error.TooSmallBidValueException;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.assertj.core.api.ThrowableAssert.catchThrowable;

public class BidsTest {

    private Bids bids;
    private Bid bid;
    private Money money;
    private User user;

    @Before
    public void Set_Up() {
        bids = new Bids();

        money = new Money(100, Currency.PLN);
        user = new User();
        bid = new Bid(money, user);
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
    public void Should_Throw_Exception_If_Bid_Is_Not_Highest() {
        // given
        bids.addBid(bid);

        // when
        final Throwable result = catchThrowable(() -> bids.addBid(bid));

        // then
        assertThat(result).isInstanceOf(TooSmallBidValueException.class);
    }

}