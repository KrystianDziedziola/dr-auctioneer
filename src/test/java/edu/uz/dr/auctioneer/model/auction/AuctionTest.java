package edu.uz.dr.auctioneer.model.auction;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Java6Assertions.assertThat;


public class AuctionTest {

    private Auction auction;

    @Before
    public void Set_Up() {
        final UserInformation userInformation = new UserInformation("Login", "Description");

        auction = new Auction.Builder()
                .setTitle("Auction")
                .setEndDate(LocalDateTime.of(2050, 12, 1, 15, 0))
                .setStartingPrice(200)
                .setCurrency(Currency.PLN)
                .setDescription("Description")
                .setUserInformation(userInformation)
                .build();
    }

    @Test
    public void Should_Add_Bid_If_Is_Higher_Than_Starting_Price() {
        // given

        // when
        auction.addBid(250, "User1");

        //then
        assertThat(auction.getNumberOfBids()).isEqualTo(2);
    }

    @Test
    public void Should_Get_Correct_Current_Price() {
        // given
        final String username = "user";
        final double newPrice = 300;

        // when
        auction.addBid(newPrice, username);

        //then
        assertThat(auction.getCurrentPrice()).isEqualTo(300);
    }
}