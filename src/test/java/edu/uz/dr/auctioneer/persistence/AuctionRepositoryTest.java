package edu.uz.dr.auctioneer.persistence;

import edu.uz.dr.auctioneer.model.Auction;
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

    @Before
    public void Set_Up() {
        repository.deleteAll();
    }

    @Test
    public void Should_Save_Auction_To_Repository() {
        //given
        final Auction auction = new Auction.Builder().build();

        //when
        repository.save(auction);
        final List<Auction> auctions = repository.findAll();

        //then
        assertThat(auctions).isNotEmpty();
    }
}