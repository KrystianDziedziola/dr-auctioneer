package edu.uz.dr.auctioneer.configuration.repository;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import edu.uz.dr.auctioneer.configuration.properties.SpringApplicationProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;

@Profile("dev")
@Configuration
public class MongoConfiguration extends AbstractMongoConfiguration {

    private final String databaseName;
    private final String databaseHost;
    private final int databasePort;

    @Autowired
    public MongoConfiguration(final SpringApplicationProperties properties) {
        databaseName = properties.getDatabaseName();
        databaseHost = properties.getDatabaseHost();
        databasePort = properties.getDatabasePort();
    }

    @Override
    protected String getDatabaseName() {
        return databaseName;
    }

    @Override
    public Mongo mongo() throws Exception {
        return new MongoClient(databaseHost, databasePort);
    }
}
