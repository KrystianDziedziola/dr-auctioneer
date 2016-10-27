package edu.uz.dr.auctioneer.configuration.repository;

import com.github.fakemongo.Fongo;
import com.mongodb.Mongo;
import edu.uz.dr.auctioneer.configuration.properties.SpringApplicationProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;

@Profile("test")
@Configuration
public class FongoConfiguration extends AbstractMongoConfiguration {

    private final String databaseName;

    @Autowired
    public FongoConfiguration(final SpringApplicationProperties properties) {
        databaseName = properties.getDatabase().getName();
    }

    @Override
    protected String getDatabaseName() {
        return databaseName;
    }

    @Override
    public Mongo mongo() throws Exception {
        return new Fongo(databaseName).getMongo();
    }
}