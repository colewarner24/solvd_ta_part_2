package booking.mybatis.services;

import booking.model.User;
import booking.mybatis.mappers.UserMapper;

public class UserService extends BaseService<User, Integer, UserMapper> {

    @Override
    protected Class<UserMapper> getMapperClass() {
        return UserMapper.class;
    }
}
