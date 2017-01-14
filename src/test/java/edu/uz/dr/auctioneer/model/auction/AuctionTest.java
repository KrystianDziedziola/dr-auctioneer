package edu.uz.dr.auctioneer.model.auction;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

public class AuctionTest {

    private Auction auction;

    @Before
    public void Set_Up() {
        final UserInformation userInformation = new UserInformation("Login", "Description");

        auction = new Auction.Builder()
                .setTitle("Auction")
                .setEndDate(LocalDateTime.of(2050, 12, 1, 15, 0))
                .setStartingPrice(200, Currency.PLN)
                .setDescription("Description")
                .setUserInformation(userInformation)
                .build();
    }

    @Test
    public void Should_Add_Bid_If_Is_Higher_Than_Starting_Price() {
        // given
        final Money bidValue = new Money(250, Currency.PLN);
        final UserInformation userInformation = new UserInformation("User1", "Description1");
        final Bid bid = new Bid(bidValue, userInformation);

        // when
        auction.addBid(bid);

        //then
        assertThat(auction.getNumberOfBids()).isEqualTo(2);
    }
}