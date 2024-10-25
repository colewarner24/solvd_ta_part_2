package booking.mybatis.services;

import booking.model.Passenger;
import booking.mybatis.mappers.PassengerMapper;

public class PassengerService extends BaseService<Passenger, Integer, PassengerMapper> {

    @Override
    protected Class<PassengerMapper> getMapperClass() {
        return PassengerMapper.class;
    }
}
