package edu.uz.dr.auctioneer.service;

import edu.uz.dr.auctioneer.model.auction.Auction;
import edu.uz.dr.auctioneer.model.auction.Currency;
import edu.uz.dr.auctioneer.model.auction.UserInformation;
import edu.uz.dr.auctioneer.persistence.AuctionRepository;
import edu.uz.dr.auctioneer.service.error.AuctionNotFoundException;
import edu.uz.dr.auctioneer.service.error.WrongPasswordException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.time.LocalDateTime;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.assertj.core.api.ThrowableAssert.catchThrowable;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class AuctionServiceTest {

    private AuctionService service;

    @Mock
    private AuctionRepository repository;
    @Mock
    private Auction auctionMock;

    private Auction auction;

    @Before
    public void Set_Up() {
        service = new AuctionService(repository);
        auction = new Auction.Builder()
                .setTitle("Auction")
                .setEndDate(LocalDateTime.of(2050, 12, 1, 15, 0))
                .setStartingPrice(200)
                .setCurrency(Currency.PLN)
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

    @Test
    public void Should_Find_Auction_By_Title() {
        // given
        when(repository.findByTitle("Auction")).thenReturn(auction);

        // when
        final Auction foundAuction = service.findByTitle("Auction");

        // then
        verify(repository, times(1)).findByTitle("Auction");
        assertThat(foundAuction).isEqualTo(auction);
    }

    @Test
    public void Should_Not_Find_Auction_By_Title() {
        // given
        when(repository.findByTitle("Auction")).thenReturn(null);

        // when
        final Throwable result = catchThrowable(() -> service.findByTitle("Auction"));

        // then
        assertThat(result).isInstanceOf(AuctionNotFoundException.class);

    }

    @Test
    public void Should_Delete_Auction_If_Auction_Is_Not_Protected_With_Password() throws WrongPasswordException {
        // given
        when(auctionMock.getPassword()).thenReturn(null);
        when(repository.findByTitle("Auction")).thenReturn(auctionMock);

        // when
        service.deleteByTitle("Auction", null);

        // then
        verify(repository, times(1)).deleteByTitle("Auction");
    }

    @Test
    public void Should_Delete_Auction_If_Password_Matches() throws WrongPasswordException {
        when(auctionMock.getPassword()).thenReturn("password");
        when(repository.findByTitle("Auction")).thenReturn(auctionMock);

        // when
        service.deleteByTitle("Auction", "password");

        // then
        verify(repository, times(1)).deleteByTitle("Auction");
    }

    @Test
    public void Should_Throw_Exception_When_Deleting_Auction_With_Wrong_Password() throws WrongPasswordException {
        when(auctionMock.getPassword()).thenReturn("password");
        when(repository.findByTitle("Auction")).thenReturn(auctionMock);

        // when
        final Throwable result = catchThrowable(() -> service.deleteByTitle("Auction", "wrong_password"));

        // then
        assertThat(result).isInstanceOf(WrongPasswordException.class);
    }

    @Test
    public void Should_Throw_Exception_When_Deleting_Unprotected_Auction_With_Some_Password() throws WrongPasswordException {
        when(auctionMock.getPassword()).thenReturn(null);
        when(repository.findByTitle("Auction")).thenReturn(auctionMock);

        // when
        final Throwable result = catchThrowable(() -> service.deleteByTitle("Auction", "password"));

        // then
        assertThat(result).isInstanceOf(WrongPasswordException.class);
    }

}