package jdbc;

import booking.constant.ProjectConstant.FactoryType;
import booking.exception.DAOException;
import booking.model.User;
import booking.services.UserService;
import booking.factory.DAOFactory;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertThrows;

public class jdbcusertests {

    private UserService userService;
    private User user1;

    @Before
    public void setUp() throws DAOException, SQLException {
        this.userService = new UserService(DAOFactory.getDAOFactory(FactoryType.MYSQL));
        userService.deleteAllUsers();

        user1 = new User("Cole", "Warner", "19cowarner@gmail.com", "password");
        userService.createUser(user1);
    }

    @Test
    public void testCreateUser() {
        Optional<User> db_user = userService.getUser(user1.getId());
        assertTrue(db_user.isPresent());
        assertEquals(user1, db_user.get());
    }

    @Test
    public void testUpdateUser() throws SQLException {
        User user = new User(user1.getId(), user1.getFirstName(), user1.getLastName(), "cole24777@gmail.com", user1.getPassword());

        userService.updateUser(user);
        Optional<User> db_user = userService.getUser(user1.getId());
        assertTrue(db_user.isPresent());
        assertEquals(user, db_user.get());
    }

    @Test
    public void testDeleteUser() {
        userService.deleteUser(user1.getId());

        Optional<User> db_user = userService.getUser(user1.getId());
        assertFalse(db_user.isPresent());
    }

    @Test
    public void testDeleteAll() {
        userService.deleteAllUsers();
        assertTrue(userService.getAllUsers().isEmpty());
    }
}
