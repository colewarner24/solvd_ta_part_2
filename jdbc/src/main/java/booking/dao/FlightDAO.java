package booking.dao;

import booking.model.Flight;

import java.util.List;
import java.util.Optional;

public interface FlightDAO {

    List<Flight> getAll();

    Optional<Flight> findById(Integer flightId);

    void create(Flight flight);

    void update(Flight flight);

    void delete(Integer flightId);

    void deleteAll();
}
