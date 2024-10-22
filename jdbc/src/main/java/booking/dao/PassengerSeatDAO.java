package booking.dao;

import booking.model.PassengerSeat;
import java.util.List;
import java.util.Optional;

public interface PassengerSeatDAO {

    void create(PassengerSeat passengerSeat);

    Optional<PassengerSeat> findById(Integer passengerSeatId);

    List<PassengerSeat> getAll();

    void update(PassengerSeat passengerSeat);

    void delete(Integer passengerSeatId);

    void deleteAll();
}
