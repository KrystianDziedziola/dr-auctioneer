package edu.uz.dr.auctioneer.model;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;


public class AuctionTest {

    private Auction auction;

    @Before
    public void Set_Up() {
        final Money startingPrice = new Money(200, Currency.PLN);
        final User user = new User("Login", "Description");

        auction = new Auction.Builder()
                .setTitle("Auction")
                .setStartingPrice(startingPrice)
                .setDescription("Description")
                .setUser(user)
                .build();
    }

    @Test
    public void Should_Add_Bid_If_Is_Higher_Than_Starting_Price() {
        // given
        final Money bidValue = new Money(250, Currency.PLN);
        final User user = new User("User1", "Description1");
        final Bid bid = new Bid(bidValue, user);

        // when
        auction.addBid(bid);

        //then
        assertThat(auction.getNumberOfBids()).isEqualTo(2);
    }
}