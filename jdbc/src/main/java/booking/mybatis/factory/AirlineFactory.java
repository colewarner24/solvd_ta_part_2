package booking.mybatis.factory;

import booking.model.Airline;

public class AirlineFactory extends Factory {
    public Airline getAirlines(String airlineName) {
        return new Airline(airlineName);
    }
}
