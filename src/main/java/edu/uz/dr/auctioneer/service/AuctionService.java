package edu.uz.dr.auctioneer.service;

import edu.uz.dr.auctioneer.model.auction.Auction;
import edu.uz.dr.auctioneer.persistence.AuctionRepository;
import edu.uz.dr.auctioneer.service.error.AuctionNotFoundException;
import edu.uz.dr.auctioneer.service.error.WrongPasswordException;
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

    public Auction findByTitle(final String title) {
        final Auction auction = repository.findByTitle(title);
        if (auction == null) {
            throw new AuctionNotFoundException();
        }

        return auction;
    }

    public void deleteByTitle(final String title, final String password) throws WrongPasswordException {
        final Auction auction = findByTitle(title);

        if (!isPasswordMatching(auction.getPassword(), password)) {
            throw new WrongPasswordException(title);
        }

        repository.deleteByTitle(title);
    }

    private boolean isPasswordMatching(final String auctionPassword, final String password) {
        if (auctionPassword != null) {
            if (!auctionPassword.equals(password)) {
                return false;
            }
        } else {
            if (password != null && !password.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    public List<Auction> getAll() {
        return repository.findAll();
    }
}
