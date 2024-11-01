package booking.mybatis.factory;

import booking.model.Flight;

public class FlightFactory extends Factory {

    public Flight getFlight(int airlineId, int departureAirportId, int arrivalAirportId, String departureTime, String flightNumber, String arrivalTime) {
        return new Flight(airlineId, departureAirportId, arrivalAirportId, departureTime, flightNumber, arrivalTime);
    }
}
