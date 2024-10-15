package booking.dao;

import booking.model.User;
import java.util.List;

public interface UserDAO extends GenericDAO {
    public void create(User user);

    public <Optional> java.util.Optional<User> findById(Integer id);

    public List<User> getAll();

    public void update(User user);

}
