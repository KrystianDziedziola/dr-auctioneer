package edu.uz.dr.auctioneer.service;

import edu.uz.dr.auctioneer.model.user.User;
import edu.uz.dr.auctioneer.model.user.error.WrongCredentialException;
import edu.uz.dr.auctioneer.persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class LogInService {

    private final UserRepository repository;

    @Autowired
    public LogInService(final UserRepository repository) {
        this.repository = repository;
    }

    public User login(final String login, final String password) {
        final Optional<User> userOptional = repository.findByCredentials_Login(login);

        if (userOptional.isPresent()) {
            final User user = userOptional.get();

            if (user.getPassword().equals(password)) {
                return user;
            }

            throw new WrongCredentialException("password");
        }

        throw new WrongCredentialException("login");
    }
}
