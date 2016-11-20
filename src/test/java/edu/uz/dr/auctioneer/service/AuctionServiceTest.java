package edu.uz.dr.auctioneer.service;

import edu.uz.dr.auctioneer.model.auction.Auction;
import edu.uz.dr.auctioneer.model.auction.Currency;
import edu.uz.dr.auctioneer.model.auction.UserInformation;
import edu.uz.dr.auctioneer.persistence.AuctionRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.time.LocalDateTime;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class AuctionServiceTest {

    private AuctionService service;

    @Mock
    private AuctionRepository repository;

    private Auction auction;

    @Before
    public void Set_Up() {
        service = new AuctionService(repository);
        auction = new Auction.Builder()
                .setTitle("Auction")
                .setEndDate(LocalDateTime.of(2016, 12, 1, 15, 0))
                .setStartingPrice(200, Currency.PLN)
                .setDescription("Description")
                .setUserInformation(new UserInformation("login", "description"))
                .build();
    }

    @Test
    public void Should_Add_Auction() {
        // given

        // when
        service.add(auction);

        // then
        verify(repository, times(1)).save(any(Auction.class));
    }
}