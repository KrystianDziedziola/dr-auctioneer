package edu.uz.dr.auctioneer.service;

import edu.uz.dr.auctioneer.model.user.Credentials;
import edu.uz.dr.auctioneer.model.user.User;
import edu.uz.dr.auctioneer.model.user.error.LoginNotAvailableException;
import edu.uz.dr.auctioneer.persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RegistrationService {

    private final UserRepository repository;

    @Autowired
    public RegistrationService(final UserRepository repository) {
        this.repository = repository;
    }

    public void registerUser(final String login, final String password) {

        if (loginExist(login)) {
            throw new LoginNotAvailableException(login);
        } else {
            final Credentials credentials = new Credentials(login, password);
            final User user = new User(credentials);
            repository.save(user);
        }
    }

    private boolean loginExist(final String login) {
        final Optional<User> user = repository.findByCredentials_Login(login);
        return user.isPresent();
    }
}
