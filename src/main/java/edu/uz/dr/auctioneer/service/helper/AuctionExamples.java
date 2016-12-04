package edu.uz.dr.auctioneer.service.helper;

import edu.uz.dr.auctioneer.model.auction.Auction;
import edu.uz.dr.auctioneer.model.auction.Currency;
import edu.uz.dr.auctioneer.model.auction.UserInformation;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class AuctionExamples {

    public static List<Auction> create() {
        final Auction firstAuction = new Auction.Builder()
                .setTitle("pierwszy")
                .setDescription("descr")
                .setStartingPrice(23, Currency.PLN)
                .setUserInformation(new UserInformation("user", ""))
                .setEndDate(LocalDateTime.of(2050, 12, 12, 11, 11, 11))
                .setMainPicturePath("")
                .build();

        final Auction secondAuction = new Auction.Builder()
                .setTitle("drugi")
                .setDescription("descr")
                .setStartingPrice(100, Currency.USD)
                .setUserInformation(new UserInformation("Pan Murzyn", ""))
                .setEndDate(LocalDateTime.of(2040, 10, 10, 5, 5, 5))
                .setMainPicturePath("")
                .build();

        return Arrays.asList(firstAuction, secondAuction);
    }
}
