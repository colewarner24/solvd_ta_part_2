package booking.dao;

import booking.model.Passenger;
import java.util.List;
import java.util.Optional;

public interface PassengerDAO {
    void create(Passenger passenger);
    Optional<Passenger> findById(Integer passengerId);
    List<Passenger> getAll();
    void update(Passenger passenger);
    void delete(Integer passengerId);
    void deleteAll();
}
