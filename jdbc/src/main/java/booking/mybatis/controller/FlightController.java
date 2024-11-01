package booking.mybatis.controller;

import booking.model.Flight;
import booking.mybatis.services.FlightService;
import booking.mybatis.view.FlightView;

import java.util.List;

public class FlightController implements Controller<Flight> {
    private final FlightService flightService;

    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    public void displayAll() {
        List<Flight> flights = flightService.getAll();
        FlightView.displayFlights(flights);
    }

    public void create(Flight flight) {
        flightService.create(flight);
        System.out.println("Flight " + flight.getFlightId() + " created successfully.");
    }

    public void delete(int flightId) {
       flightService.delete(flightId);
        System.out.println("Flight: " + flightId + " deleted successfully.");
    }

    public void update(Flight flight) {
        flightService.update(flight);
        System.out.println("Flight: " + flight.getFlightId() + " updated successfully.");
    }

    public Flight findById(int flightId) {
        return flightService.findById(flightId);
    }
}
