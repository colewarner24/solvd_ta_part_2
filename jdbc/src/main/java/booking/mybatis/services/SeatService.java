package booking.mybatis.services;

import booking.model.Seat;
import booking.mybatis.mappers.SeatMapper;

public class SeatService extends BaseService<Seat, Integer, SeatMapper> {

    @Override
    protected Class<SeatMapper> getMapperClass() {
        return SeatMapper.class;
    }
}
