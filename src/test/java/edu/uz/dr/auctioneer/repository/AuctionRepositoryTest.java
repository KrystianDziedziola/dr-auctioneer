package edu.uz.dr.auctioneer.repository;

import edu.uz.dr.auctioneer.model.Auction;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class AuctionRepositoryTest {

    @Autowired
    private AuctionRepository repository;

    @Before
    public void before() {
        repository.deleteAll();
    }

    @Test
    public void shouldSaveAuctionToRepository() {
        //given

        //when
        repository.save(new Auction("text"));
        final List<Auction> auctions = repository.findAll();

        //then
        assertThat(auctions).isNotEmpty();
    }
}