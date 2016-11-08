package edu.uz.dr.auctioneer.persistence;

import edu.uz.dr.auctioneer.model.Auction;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuctionRepository extends MongoRepository<Auction, String> {

}
