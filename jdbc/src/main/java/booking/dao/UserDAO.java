package booking.dao;

import booking.model.User;
import java.util.List;

public interface UserDAO extends GenericDAO {
    public void create(User user);

    public User findById(Integer id);

    public List<User> getAll();

    public void update(User user);

    public void delete(Integer id);

    public void deleteAll();

}
