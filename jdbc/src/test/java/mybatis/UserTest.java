package mybatis;

import booking.model.User;
import booking.mybatis.services.UserService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class UserTest {

    private User user1;
    private UserService userService;

    @Before
    public void setUp() {
        userService = new UserService();
        user1 = new User("Cole", "Warner", "19cowarner@gmail.com", "password");
        userService.create(user1);
    }

    @Test
    public void testCreateUser() {
        User db_user = userService.findById(user1.getId());
        assert user1.equals(db_user);
    }

    @Test
    public void updateUser() {
        User userUpdate = new User(user1.getId(), user1.getFirstName(), user1.getLastName(), "cole24777@gmail.com", user1.getPassword());
        userService.update(userUpdate);
        User db_user = userService.findById(user1.getId());
        assert userUpdate.equals(db_user);
    }

    @Test
    public void deleteUser() {
        userService.delete(user1.getId());
        User db_user = userService.findById(user1.getId());
        assert db_user == null;
    }

    @After
    public void tearDown() {
        userService.delete(user1.getId());
    }
}
