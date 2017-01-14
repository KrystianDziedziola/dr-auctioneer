package edu.uz.dr.auctioneer.model.auction;

import org.junit.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.assertj.core.api.Java6Assertions.catchThrowable;

public class AuctionBuilderTest {

    private final Auction.Builder builder = new Auction.Builder();

    private final String title = "title";
    private final String description = "description";
    private final double startingPriceAmount = 200;
    private final Currency currency = Currency.PLN;
    private final String mainPicturePath = "/picture.png";
    private final LocalDateTime endDate = LocalDateTime.of(2050, 12, 30, 15, 30);
    private final UserInformation userInformation = new UserInformation("login", "description");

    @Test
    public void Should_Build_Auction() {
        // given

        // when
        final Auction auction = builder
                .setTitle(title)
                .setDescription(description)
                .setStartingPrice(startingPriceAmount)
                .setCurrency(currency)
                .setMainPicturePath(mainPicturePath)
                .setEndDate(endDate)
                .setUserInformation(userInformation)
                .build();

        // then
        assertThat(auction).isNotNull();
    }

    @Test
    public void Should_Throw_Exception_If_Empty_Title() {
        // given
        final String title = "";

        // when
        final Throwable result = catchThrowable(() -> builder
                .setTitle(title)
                .setDescription(description)
                .setStartingPrice(startingPriceAmount)
                .setCurrency(currency)
                .setMainPicturePath(mainPicturePath)
                .setEndDate(endDate)
                .setUserInformation(userInformation)
                .build());

        // then
        assertThat(result).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void Should_Throw_Exception_If_No_Title() {
        // given

        // when
        final Throwable result = catchThrowable(() -> builder
                .setDescription(description)
                .setStartingPrice(startingPriceAmount)
                .setCurrency(currency)
                .setMainPicturePath(mainPicturePath)
                .setEndDate(endDate)
                .setUserInformation(userInformation)
                .build());

        // then
        assertThat(result).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void Should_Throw_Exception_If_Wrong_Starting_Price() {
        // given
        final double startingPriceAmount = -10;

        // when
        final Throwable result = catchThrowable(() -> builder
                .setTitle(title)
                .setDescription(description)
                .setStartingPrice(startingPriceAmount)
                .setCurrency(currency)
                .setMainPicturePath(mainPicturePath)
                .setEndDate(endDate)
                .setUserInformation(userInformation)
                .build());

        // then
        assertThat(result).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void Should_Throw_Exception_If_No_Starting_Price() {
        // given

        // when
        final Throwable result = catchThrowable(() -> builder
                .setTitle(title)
                .setDescription(description)
                .setMainPicturePath(mainPicturePath)
                .setEndDate(endDate)
                .setUserInformation(userInformation)
                .build());

        // then
        assertThat(result).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void Should_Throw_Exception_If_No_End_Date() {
        // given

        // when
        final Throwable result = catchThrowable(() -> builder
                .setTitle(title)
                .setDescription(description)
                .setStartingPrice(startingPriceAmount)
                .setCurrency(currency)
                .setMainPicturePath(mainPicturePath)
                .setUserInformation(userInformation)
                .build());

        // then
        assertThat(result).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void Should_Throw_Exception_If_End_Date_Before_Now() {
        // given
        final LocalDateTime endDateBeforeNow = LocalDateTime.of(2016, 10, 10, 10, 10);

        // when
        final Throwable result = catchThrowable(() -> builder
                .setTitle(title)
                .setDescription(description)
                .setStartingPrice(startingPriceAmount)
                .setCurrency(currency)
                .setMainPicturePath(mainPicturePath)
                .setEndDate(endDateBeforeNow)
                .setUserInformation(userInformation)
                .build());

        // then
        assertThat(result).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void Should_Throw_Exception_If_No_User_Information() {
        // given

        // when
        final Throwable result = catchThrowable(() -> builder
                .setTitle(title)
                .setDescription(description)
                .setStartingPrice(startingPriceAmount)
                .setCurrency(currency)
                .setMainPicturePath(mainPicturePath)
                .setEndDate(endDate)
                .build());

        // then
        assertThat(result).isInstanceOf(IllegalArgumentException.class);
    }
}