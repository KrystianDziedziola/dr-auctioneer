package edu.uz.dr.auctioneer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableMongoRepositories
@EnableWebMvc
public class DrAuctioneerApplication {

    public static void main(final String[] args) {
        SpringApplication.run(DrAuctioneerApplication.class, args);
    }
}