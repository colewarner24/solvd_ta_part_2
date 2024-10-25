package mybatis;

import booking.model.FlightPricing;
import booking.mybatis.services.FlightPricingService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FlightPricingTest {

    private FlightPricing flightPricing1;
    private FlightPricingService flightPricingService;

    @Before
    public void setUp() {
        flightPricingService = new FlightPricingService();
        flightPricing1 = new FlightPricing(5, 200.00, "economy");
        flightPricingService.create(flightPricing1);
    }

    @Test
    public void testCreateFlightPricing() {
        FlightPricing db_flightPricing = flightPricingService.findById(flightPricing1.getId());
        assert flightPricing1.equals(db_flightPricing);
    }

    @Test
    public void updateFlightPricing() {
        FlightPricing flightPricingUpdate = new FlightPricing(flightPricing1.getId(), flightPricing1.getFlightId(), 250.00, "business"); // Updating price and flightClass
        flightPricingService.update(flightPricingUpdate);
        FlightPricing db_flightPricing = flightPricingService.findById(flightPricing1.getId());
        assert flightPricingUpdate.equals(db_flightPricing);
    }

    @Test
    public void deleteFlightPricing() {
        flightPricingService.delete(flightPricing1.getId());
        FlightPricing db_flightPricing = flightPricingService.findById(flightPricing1.getId());
        assert db_flightPricing == null;
    }

    @After
    public void tearDown() {
        flightPricingService.delete(flightPricing1.getId());
    }
}
