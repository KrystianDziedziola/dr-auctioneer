package edu.uz.dr.auctioneer.service;

import edu.uz.dr.auctioneer.model.user.User;
import edu.uz.dr.auctioneer.model.user.error.WrongCredentialException;
import edu.uz.dr.auctioneer.persistence.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Optional;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.assertj.core.api.Java6Assertions.catchThrowable;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LogInServiceTest {

    private LogInService service;

    @Mock
    private UserRepository repository;

    @Before
    public void Set_Up() {
        service = new LogInService(repository);
    }

    @Test
    public void Should_Log_In() {
        // given
        final String login = "login";
        final String password = "password";

        final User userMock = mock(User.class);
        when(userMock.getPassword()).thenReturn(password);

        when(repository.findByCredentials_Login(login)).thenReturn(Optional.of(userMock));

        // when
        final User user = service.login(login, password);

        // then
        assertThat(user).isNotNull();
    }

    @Test
    public void Should_Throw_Exception_If_Wrong_Login() {
        // given
        final String login = "login123";
        final String password = "password";

        when(repository.findByCredentials_Login(login)).thenReturn(Optional.empty());

        // when
        final Throwable result = catchThrowable(() -> service.login(login, password));

        // then
        assertThat(result).isInstanceOf(WrongCredentialException.class);
    }

    @Test
    public void Should_Throw_Exception_If_Wrong_Password() {
        // given
        final String login = "login";
        final String password = "password123";

        final User userMock = mock(User.class);
        when(userMock.getPassword()).thenReturn("password");

        when(repository.findByCredentials_Login(login)).thenReturn(Optional.of(userMock));

        // when
        final Throwable result = catchThrowable(() -> service.login(login, password));

        // then
        assertThat(result).isInstanceOf(WrongCredentialException.class);
    }
}