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
                .setDescription("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.")
                .setStartingPrice(2_000)
                .setCurrency(Currency.PLN)
                .setMainPicturePath("http://pngimg.com/upload/computer_pc_PNG7719.png")
                .setUserInformation(new UserInformation("Krystian", "Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo."))
                .setEndDate(LocalDateTime.now().plusSeconds(2))
                .build();

        final Auction secondAuction = new Auction.Builder()
                .setTitle("Honda Car")
                .setDescription("Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur? Quis autem vel eum iure reprehenderit qui in ea voluptate velit esse quam nihil molestiae consequatur, vel illum qui dolorem eum fugiat quo voluptas nulla pariatur?")
                .setStartingPrice(10_000)
                .setCurrency(Currency.USD)
                .setMainPicturePath("http://hiswheel.com/images/honda-car-2.jpg")
                .setUserInformation(new UserInformation("Pan Piotr", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."))
                .setEndDate(LocalDateTime.of(2040, 10, 10, 5, 5, 5))
                .build();

        return Arrays.asList(firstAuction, secondAuction);
    }
}
