package booking.dao;

import booking.model.Seat;
import java.util.List;
import java.util.Optional;

public interface SeatDAO {

    void create(Seat seat);

    Optional<Seat> findById(Integer seatId);

    List<Seat> getAll();

    void update(Seat seat);

    void delete(Integer seatId);

    void deleteAll();
}
