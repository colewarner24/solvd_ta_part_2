package booking.mybatis.services;

import booking.model.Flight;
import booking.mybatis.mappers.FlightMapper;

public class FlightService extends BaseService<Flight, Integer, FlightMapper> {

    @Override
    protected Class<FlightMapper> getMapperClass() {
        return FlightMapper.class;
    }
}
