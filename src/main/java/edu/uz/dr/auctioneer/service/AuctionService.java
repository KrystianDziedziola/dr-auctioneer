package edu.uz.dr.auctioneer.service;

import edu.uz.dr.auctioneer.model.auction.Auction;
import edu.uz.dr.auctioneer.persistence.AuctionRepository;
import edu.uz.dr.auctioneer.service.helper.AuctionExamples;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public void addExamples() {
        repository.save(AuctionExamples.create());
    }

    public List<Auction> getAll() {
        return repository.findAll();
    }
}
