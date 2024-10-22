package booking.dao;

import booking.model.Airport;

import java.util.List;
import java.util.Optional;

public interface AirportDAO extends GenericDAO {

    void insert(Airport airport);

    Optional<Airport> findById(int id);

    List<Airport> findAll();

    void update(Airport airport);

}
