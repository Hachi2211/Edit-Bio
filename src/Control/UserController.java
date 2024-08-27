package Control;

import ADT.ListInterface;
import DAO.User_initializer;
import Entity.User;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class UserController {
    private static final UserController instance = new UserController();
    private final User_initializer userDAO;
    private final ListInterface<User> userList;

    private UserController() {
        userDAO = new User_initializer();
        userList = userDAO.initializeUser();
    }

    public static UserController getInstance() {
        return instance;
    }

    public ListInterface<User> getAllUsers() {
        return userList;
    }

    public User getCurrentUser() {
        return userList.getItem(1); // Assuming the first user is the current user
    }

    public boolean canUpdateUsername(User user) {
        LocalDateTime lastUpdated = user.getLastUpdated();
        if (lastUpdated == null) {
            return true;
        }
        return ChronoUnit.DAYS.between(lastUpdated, LocalDateTime.now()) >= 14;
    }

    public long getDaysUntilNextUpdate(User user) {
        LocalDateTime lastUpdated = user.getLastUpdated();
        if (lastUpdated == null) {
            return 0;
        }
        long daysSinceLastUpdate = ChronoUnit.DAYS.between(lastUpdated, LocalDateTime.now());
        return Math.max(0, 14 - daysSinceLastUpdate);
    }

    public boolean updateUsername(User user, String newUsername) {
        if (!newUsername.equals(user.getUsername())) {
            user.setUsername(newUsername);
            user.setLastUpdated(LocalDateTime.now());
            return true;
        }
        return false;
    }

    public void updateBio(User user, String newBio) {
        user.setBio(newBio);
    }
}
