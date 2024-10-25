package booking.mybatis.services;

import booking.model.PassengerSeat;
import booking.mybatis.mappers.PassengerSeatMapper;

public class PassengerSeatService extends BaseService<PassengerSeat, Integer, PassengerSeatMapper> {

    @Override
    protected Class<PassengerSeatMapper> getMapperClass() {
        return PassengerSeatMapper.class;
    }
}
