package edu.uz.dr.auctioneer.persistence;

import edu.uz.dr.auctioneer.model.user.Credentials;
import edu.uz.dr.auctioneer.model.user.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Optional;

import static org.assertj.core.api.Java6Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class UserRepositoryTest {

    @Autowired
    private UserRepository repository;

    private User user;

    @Before
    public void Set_Up() {
        final Credentials credentials = new Credentials("login", "password");
        user = new User(credentials);

        repository.deleteAll();
    }

    @Test
    public void Should_Save_User() {
        // given

        // when
        repository.save(user);

        // then
        assertThat(repository.findAll()).hasSize(1);
    }

    @Test
    public void Should_Get_User_By_Login() {
        // given
        repository.save(user);

        // when
        final Optional<User> foundUser = repository.findByCredentials_Login("login");

        // then
        assertThat(foundUser.isPresent()).isTrue();
    }

    @Test
    public void Should_Not_Get_User_By_Login() {
        // given
        repository.save(user);

        // when
        final Optional<User> foundUser = repository.findByCredentials_Login("login123");

        // then
        assertThat(foundUser.isPresent()).isFalse();
    }
}