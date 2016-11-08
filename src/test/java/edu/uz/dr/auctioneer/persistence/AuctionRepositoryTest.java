package edu.uz.dr.auctioneer.persistence;

import edu.uz.dr.auctioneer.model.Auction;
import edu.uz.dr.auctioneer.model.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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

        final User user = new User("Login", "Description");

        auction = new Auction.Builder()
                .setTitle("Auction")
                .setDescription("Description")
                .setUser(user)
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