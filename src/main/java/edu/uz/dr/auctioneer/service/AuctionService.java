package edu.uz.dr.auctioneer.service;

import edu.uz.dr.auctioneer.model.auction.Auction;
import edu.uz.dr.auctioneer.persistence.AuctionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuctionService {

    private final AuctionRepository repository;

    @Autowired
    public AuctionService(final AuctionRepository repository) {
        this.repository = repository;
    }

    public void add(final Auction auction) {
        repository.save(auction);
    }
}
