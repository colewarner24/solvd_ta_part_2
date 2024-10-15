package booking.dao;

import booking.model.Booking;
import java.util.List;
import java.util.Optional;

public interface BookingDAO {

    void create(Booking booking);

    Optional<Booking> findById(Integer bookingId);

    List<Booking> getAll();

    void update(Booking booking);

    void delete(Integer bookingId);

    void deleteAll();
}
