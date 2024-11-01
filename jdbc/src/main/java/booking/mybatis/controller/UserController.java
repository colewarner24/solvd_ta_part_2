package booking.mybatis.controller;


import booking.model.User;
import booking.mybatis.services.UserService;
import booking.mybatis.view.UserView;

import java.util.List;

public class UserController implements Sortable<User> {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public void displayAll() {
        List<User> users = userService.getAll();
        UserView.displayUsers(users);
    }

    public void displayAllSortedByName() {
        List<User> users = userService.getAllSortedByName();
        UserView.displayUsers(users);
    }

    public void displayAllSortedById() {
        List<User> users = userService.getAllSortedById();
        UserView.displayUsers(users);
    }

    public void create(User user) {
        userService.create(user);
        System.out.println("User " + user.getId() + " created successfully.");
    }

    public void delete(int userId) {
        userService.delete(userId);
        System.out.println("User: " + userId + " deleted successfully.");
    }

    public void update(User user) {
        userService.update(user);
        System.out.println("User: " + user.getId() + " updated successfully.");
    }

    public User findById(int userId) {
        return userService.findById(userId);
    }
}
