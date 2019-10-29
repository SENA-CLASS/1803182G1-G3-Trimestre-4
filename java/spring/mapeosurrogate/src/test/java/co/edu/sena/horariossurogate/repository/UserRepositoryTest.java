package co.edu.sena.horariossurogate.repository;

import co.edu.sena.horariossurogate.domain.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void insertar(){
        User u = new User();
        u.setActivated(1);
        u.setEmail("asdfdfasdf@dsfasd");
        u.setActivationKey("asdfasdfasdf");
        u.setLogin("asdfasdfasdf");
        u.setPassword("asdfasdfasdf");
        u.setLangKey("es");
        userRepository.save(u);
    }
}