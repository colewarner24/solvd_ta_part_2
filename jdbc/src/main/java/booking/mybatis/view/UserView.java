package booking.mybatis.view;

import booking.model.User;
import java.util.List;

public class UserView {

    public static void displayUsers(List<User> users) {
        System.out.println("Users:");
        for (User user : users) {
            System.out.println("ID: " + user.getId() + ", Name: " + user.getFirstName() + " " + user.getLastName());
        }
    }

    public static void displayUser(User user) {
        System.out.println("User Details:");
        System.out.println("ID: " + user.getId());
        System.out.println("Name: " + user.getFirstName() + " " + user.getLastName());
    }
}

