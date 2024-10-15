package booking.dao;

import booking.model.Airline;
import java.util.List;

public interface AirlinesDAO extends GenericDAO {
    void create(Airline airline);
    Airline findById(Integer id);
    List<Airline> getAll();
    void update(Airline airline);
    void delete(Integer id);
    void deleteAll();
}
