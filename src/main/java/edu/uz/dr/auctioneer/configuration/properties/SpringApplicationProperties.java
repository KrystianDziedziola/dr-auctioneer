package edu.uz.dr.auctioneer.configuration.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "auctioneer")
@Component
public class SpringApplicationProperties {

    private DatabaseProperties database;

    public DatabaseProperties getDatabase() {
        return database;
    }

    public void setDatabase(final DatabaseProperties database) {
        this.database = database;
    }

    public String getDatabaseName() {
        return database.getName();
    }
}