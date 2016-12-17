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
                .setTitle("PC Computer")
                .setDescription("Opis")
                .setStartingPrice(2_000, Currency.PLN)
                .setMainPicturePath("")
                .setUserInformation(new UserInformation("Krystian", "Taki gość"))
                .setEndDate(LocalDateTime.of(2050, 12, 12, 11, 11, 11))
                .build();

        final Auction secondAuction = new Auction.Builder()
                .setTitle("Honda Car")
                .setDescription("Opis")
                .setStartingPrice(10_000, Currency.USD)
                .setMainPicturePath("http://hiswheel.com/images/honda-car-2.jpg")
                .setUserInformation(new UserInformation("Pan Murzyn", "Wielbiciel azjatek"))
                .setEndDate(LocalDateTime.of(2040, 10, 10, 5, 5, 5))
                .build();

        return Arrays.asList(firstAuction, secondAuction);
    }
}
