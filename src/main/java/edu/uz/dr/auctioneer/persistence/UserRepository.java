package edu.uz.dr.auctioneer.persistence;

import edu.uz.dr.auctioneer.model.user.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

    Optional<User> findByCredentials_Login(String login);
}
