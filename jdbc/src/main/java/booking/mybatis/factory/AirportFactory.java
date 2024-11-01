package booking.mybatis.factory;

import booking.model.Airport;

public class AirportFactory extends Factory {
    public Airport getAirport(String airportName, String airportCity, String airportCode, String airportCountry) {
        return new Airport(airportName, airportCity, airportCode, airportCountry);
    }
}
