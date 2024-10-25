package booking.mybatis.services;

import booking.model.Airport;
import booking.mybatis.mappers.AirportMapper;

public class AirportService extends BaseService<Airport, Integer, AirportMapper> {

    @Override
    protected Class<AirportMapper> getMapperClass() {
        return AirportMapper.class;
    }
}
