package booking.mybatis.services;

import booking.model.Airline;
import booking.mybatis.mappers.AirlineMapper;

public class AirlineService extends BaseService<Airline, Integer, AirlineMapper> {

    @Override
    protected Class<AirlineMapper> getMapperClass() {
        return AirlineMapper.class;
    }
}
