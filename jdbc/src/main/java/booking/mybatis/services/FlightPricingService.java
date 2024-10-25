package booking.mybatis.services;

import booking.model.FlightPricing;
import booking.mybatis.mappers.FlightPricingMapper;

public class FlightPricingService extends BaseService<FlightPricing, Integer, FlightPricingMapper> {

    @Override
    protected Class<FlightPricingMapper> getMapperClass() {
        return FlightPricingMapper.class;
    }
}
