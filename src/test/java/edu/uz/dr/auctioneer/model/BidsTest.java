package edu.uz.dr.auctioneer.model;

import edu.uz.dr.auctioneer.model.error.TooSmallBidValueException;
import edu.uz.dr.auctioneer.model.error.WrongCurrencyException;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.assertj.core.api.ThrowableAssert.catchThrowable;

public class BidsTest {

    private Bids bids;
    private Bid bid;
    private User user;

    @Before
    public void Set_Up() {
        bids = new Bids();

        final Money money = new Money(100, Currency.PLN);
        user = new User("Login", "Description");
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
    public void Should_Add_Bid_If_It_Is_The_Highest() {
        // given
        bids.addBid(bid);

        final Bid higherBid = new Bid(new Money(150, Currency.PLN), user);

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

    @Test
    public void Should_Throw_Exception_If_Bid_Currency_Do_Not_Match() {
        // given
        bids.addBid(bid);

        final Bid usdBid = new Bid(new Money(150, Currency.USD), user);

        // when
        final Throwable result = catchThrowable(() -> bids.addBid(usdBid));

        // then
        assertThat(result).isInstanceOf(WrongCurrencyException.class);
    }

}