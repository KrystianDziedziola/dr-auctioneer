package edu.uz.dr.auctioneer.configuration;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;

@Profile("dev")
@Configuration
public class MongoConfiguration extends AbstractMongoConfiguration {

    @Override
    protected String getDatabaseName() {
        //to pobrać z .properties
        return "dr-auctioneer";
    }

    @Override
    public Mongo mongo() throws Exception {
        return new MongoClient("dr-auctioneer");
    }
}
