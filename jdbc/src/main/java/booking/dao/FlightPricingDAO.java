package booking.dao;

import booking.model.FlightPricing;
import java.util.List;
import java.util.Optional;

public interface FlightPricingDAO {

    void create(FlightPricing flightPricing);

    Optional<FlightPricing> findById(Integer flightPricingId);

    List<FlightPricing> getAll();

    void update(FlightPricing flightPricing);

    void delete(Integer flightPricingId);

    void deleteAll();
}
