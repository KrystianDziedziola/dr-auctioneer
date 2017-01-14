package edu.uz.dr.auctioneer.persistence;

import edu.uz.dr.auctioneer.model.auction.Auction;
import edu.uz.dr.auctioneer.model.auction.Currency;
import edu.uz.dr.auctioneer.model.auction.UserInformation;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class AuctionRepositoryTest {

    @Autowired
    private AuctionRepository repository;

    private Auction auction;

    @Before
    public void Set_Up() {
        repository.deleteAll();

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
    public void Should_Save_Auction_To_Repository() {
        //given

        //when
        repository.save(auction);
        final List<Auction> auctions = repository.findAll();

        //then
        assertThat(auctions).isNotEmpty();
    }
}