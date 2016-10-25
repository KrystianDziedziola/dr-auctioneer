package edu.uz.dr.auctioneer.configuration;

import com.github.fakemongo.Fongo;
import com.mongodb.Mongo;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;

@Profile("test")
@Configuration
public class FongoConfiguration extends AbstractMongoConfiguration {

    @Override
    protected String getDatabaseName() {
        //to pobrać z .properties
        return "dr-auctioneer";
    }

    @Override
    public Mongo mongo() throws Exception {
        return new Fongo("dr-auctioneer").getMongo();
    }
}