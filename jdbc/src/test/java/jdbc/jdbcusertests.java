package jdbc;

import booking.constant.ProjectConstant.FactoryType;
import booking.exception.DAOException;
import booking.model.User;
import booking.services.UserService;
import booking.factory.DAOFactory;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;

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
        User db_user = userService.getUser(user1.getId());
        assert user1.equals(db_user);
    }

    @Test
    public void testUpdateUser() throws SQLException {
        User user = new User(user1.getId(), user1.getFirstName(), user1.getLastName(), "cole24777@gmail.com", user1.getPassword());

        userService.updateUser(user);
        User db_user = userService.getUser(user1.getId());
        assert user.equals(db_user);
    }

    @Test
    public void testDeleteUser() {
        userService.deleteUser(user1.getId());

        assertThrows(DAOException.class, () -> userService.getUser(user1.getId()));
    }

    @Test
    public void testDeleteAll() {
        userService.deleteAllUsers();
        assert userService.getAllUsers().isEmpty();
    }
}
