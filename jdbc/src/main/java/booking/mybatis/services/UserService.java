package booking.mybatis.services;

import booking.model.User;
import booking.mybatis.mappers.UserMapper;
import booking.mybatis.services.strategy.SortById;
import booking.mybatis.services.strategy.SortByName;

import java.util.List;

public class UserService extends BaseService<User, Integer, UserMapper> {

    @Override
    protected Class<UserMapper> getMapperClass() {
        return UserMapper.class;
    }

    public List<User> getAllSortedByName() {
        return getAll(new SortByName());
    }

    public List<User> getAllSortedById() {
        return getAll(new SortById());
    }
}
