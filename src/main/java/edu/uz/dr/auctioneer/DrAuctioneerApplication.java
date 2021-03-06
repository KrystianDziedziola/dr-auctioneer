package edu.uz.dr.auctioneer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class DrAuctioneerApplication {

    public static void main(final String[] args) {
        SpringApplication.run(DrAuctioneerApplication.class, args);
    }
}