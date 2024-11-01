package booking.mybatis.factory;

import booking.model.User;

public class UserFactory extends Factory {

    public User getUser(String firstName, String lastName, String email, String password) {
        return new User(firstName, lastName, email, password);
    }
}
