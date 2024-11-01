package booking.mybatis.listener;

import booking.model.User;

public class UserServiceListener implements ServiceListener<User> {
    @Override
    public void onCreate(User entity) {
        System.out.println("User created: " + entity);
    }

    @Override
    public void onUpdate(User entity) {
        System.out.println("User updated: " + entity);
    }

    @Override
    public void onDelete(User entity) {
        System.out.println("User deleted: " + entity);
    }
}