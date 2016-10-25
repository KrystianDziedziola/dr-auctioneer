package edu.uz.dr.auctioneer.configuration;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;

@Configuration
public class MongoConfiguration extends AbstractMongoConfiguration {

    @Override
    protected String getDatabaseName() {
        return "dr-auctioneer";
    }

    @Override
    public Mongo mongo() throws Exception {
        return new MongoClient();
    }
}
