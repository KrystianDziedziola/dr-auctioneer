package edu.uz.dr.auctioneer.service;

import edu.uz.dr.auctioneer.model.user.User;
import edu.uz.dr.auctioneer.model.user.error.LoginNotAvailableException;
import edu.uz.dr.auctioneer.persistence.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Optional;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.assertj.core.api.Java6Assertions.catchThrowable;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class RegistrationServiceTest {

    private RegistrationService service;

    @Mock
    private UserRepository repository;

    @Before
    public void Set_Up() {
        service = new RegistrationService(repository);
    }

    @Test
    public void Should_Register_User() {
        // given
        when(repository.findByCredentials_Login("login")).thenReturn(Optional.empty());

        // when
        service.registerUser("login", "password");

        // then
        verify(repository, times(1)).save(any(User.class));
    }

    @Test
    public void Should_Not_Register_User_If_Login_Exist() {
        // given
        when(repository.findByCredentials_Login("login123")).thenReturn(Optional.of(mock(User.class)));

        // when
        final Throwable result = catchThrowable(() -> service.registerUser("login123", "password123"));

        // then
        assertThat(result).isInstanceOf(LoginNotAvailableException.class);
    }
}