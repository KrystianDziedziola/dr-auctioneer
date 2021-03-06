package edu.uz.dr.auctioneer.model.auction;

import edu.uz.dr.auctioneer.model.auction.error.AuctionFinishedException;
import org.junit.Before;
import org.junit.Test;
import pl.pojo.tester.api.assertion.Method;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.mockito.internal.util.reflection.Whitebox.setInternalState;
import static pl.pojo.tester.api.FieldPredicate.exclude;
import static pl.pojo.tester.api.assertion.Assertions.assertPojoMethodsFor;

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
    public void Should_Pass_All_Pojo_Tests() {
        // given
        final Class<?> classUnderTest = Auction.class;

        // when

        // then
        assertPojoMethodsFor(classUnderTest, exclude("startDate"))
                .testing(Method.CONSTRUCTOR, Method.GETTER)
                .areWellImplemented();
    }

    @Test
    public void Should_Add_Bid_If_Is_Higher_Than_Starting_Price() throws AuctionFinishedException {
        // given

        // when
        auction.addBid(250, "User1");

        //then
        assertThat(auction.getNumberOfBids()).isEqualTo(2);
    }

    @Test
    public void Should_Get_Correct_Current_Price() throws AuctionFinishedException {
        // given
        final String username = "user";
        final double newPrice = 300;

        // when
        auction.addBid(newPrice, username);

        //then
        assertThat(auction.getCurrentPrice()).isEqualTo(300);
    }

    @Test
    public void Should_Throw_Exception_When_Bid_After_End_Of_Auction() {
        // given
        setInternalState(auction, "endDate", LocalDateTime.of(2010, 12, 12, 12, 12));

        // when
        final Throwable result = catchThrowable(() -> auction.addBid(2.0, "user"));

        // then
        assertThat(result).isInstanceOf(AuctionFinishedException.class);
    }
}