package booking.mybatis.view;

import booking.model.Flight;

import java.util.List;

public class FlightView {

    public static void displayFlights(List<Flight> flights) {
        if (flights.isEmpty()) {
            System.out.println("No flights available.");
        } else {
            System.out.println("Flight List:");
            for (Flight flight : flights) {
                displayFlightDetails(flight);
            }
        }
    }

    public static void displayFlightDetails(Flight flight) {
        System.out.println("Flight ID: " + flight.getFlightId());
        System.out.println("Airline ID: " + flight.getAirlineId());
        System.out.println("Departure Airport ID: " + flight.getDepartureAirportId());
        System.out.println("Arrival Airport ID: " + flight.getArrivalAirportId());
        System.out.println("Departure Time: " + flight.getDepartureTime());
        System.out.println("Flight Number: " + flight.getFlightNumber());
        System.out.println("Arrival Time: " + flight.getArrivalTime());
        System.out.println("----------------------------------------------------");
    }
}