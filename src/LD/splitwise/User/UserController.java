package LD.splitwise.User;

import java.util.ArrayList;
import java.util.List;

public class UserController {
    List<User> users;

    public UserController() {
        this.users = new ArrayList<>();
    }

    public void addUser(User user) {
            users.add(user);
    }

    public User getUserById(String userId) {
        for (User user : users) {
            if (user.getUserId().equals(userId)) {
                return user;
            }
        }
        return null; // or throw an exception if preferred
    }

    public List<User> getUsers() {
        return users;
    }

    public void removeUser(User user) {
        users.remove(user);
    }
}
