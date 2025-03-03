package ck.tools.user;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Test
    public void testFindUserById() {
        // Arrange
        Long userId = 1L;
        User expectedUser = new User();
        expectedUser.setId(userId);
        expectedUser.setName("Test User");
        when(userRepository.findById(userId)).thenReturn(java.util.Optional.of(expectedUser));

        // Act
        User actualUser = userService.getUserById(userId);

        // Assert
        assertNotNull(actualUser);
        assertEquals(expectedUser.getId(), actualUser.getId());
        assertEquals(expectedUser.getName(), actualUser.getName());
        verify(userRepository, times(1)).findById(userId);
    }

    @Test
    public void testCreateUser() {
        // Arrange
        User userToSave = new User();
        userToSave.setName("New User");
        User savedUser = new User();
        savedUser.setName("New User");
        System.out.println(userRepository.save(userToSave));
    }
}
