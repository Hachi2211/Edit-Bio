package Entity;

import java.time.LocalDateTime;

public class User implements Comparable<User> {
    private String userID;
    private String username;
    private String bio;
    private LocalDateTime lastUpdated;

    public User(String userID, String username, String bio, LocalDateTime lastUpdated) {
        this.userID = userID;
        this.username = username;
        this.bio = bio;
        this.lastUpdated = lastUpdated;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(LocalDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    @Override
    public int compareTo(User o) {
        return this.userID.compareTo(o.userID);
    }

    @Override
    public String toString() {
        return "User{" +
                "userID='" + userID + '\'' +
                ", username='" + username + '\'' +
                ", bio='" + bio + '\'' +
                '}';
    }
}
