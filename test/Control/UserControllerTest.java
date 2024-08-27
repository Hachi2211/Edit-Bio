package Control;

import ADT.ListInterface;
import Entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

class UserControllerTest {

    private UserController userController;
    private User testUser;

    @BeforeEach
    void setUp() {
        userController = UserController.getInstance();
        testUser = new User("U001", "TestUser", "Test Bio");
    }

    @Test
    void testGetInstance() {
        assertNotNull(userController);
        assertEquals(userController, UserController.getInstance());
    }

    @Test
    void testGetAllUsers() {
        ListInterface<User> users = userController.getAllUsers();
        assertNotNull(users);
        assertTrue(users.getNumberOfEntries() > 0);
    }

    @Test
    void testGetCurrentUser() {
        User currentUser = userController.getCurrentUser();
        assertNotNull(currentUser);
    }

    @Test
    void testCanUpdateUsername() {
        testUser.setLastUpdated(LocalDateTime.now().minusDays(15));
        assertTrue(userController.canUpdateUsername(testUser));

        testUser.setLastUpdated(LocalDateTime.now().minusDays(13));
        assertFalse(userController.canUpdateUsername(testUser));
    }

    @Test
    void testGetDaysUntilNextUpdate() {
        testUser.setLastUpdated(LocalDateTime.now().minusDays(7));
        assertEquals(7, userController.getDaysUntilNextUpdate(testUser));

        testUser.setLastUpdated(LocalDateTime.now().minusDays(14));
        assertEquals(0, userController.getDaysUntilNextUpdate(testUser));
    }

    @Test
    void testUpdateUsername() {
        String newUsername = "NewTestUser";
        assertTrue(userController.updateUsername(testUser, newUsername));
        assertEquals(newUsername, testUser.getUsername());

        assertFalse(userController.updateUsername(testUser, newUsername));
    }

    @Test
    void testUpdateBio() {
        String newBio = "New Test Bio";
        userController.updateBio(testUser, newBio);
        assertEquals(newBio, testUser.getBio());
    }
}