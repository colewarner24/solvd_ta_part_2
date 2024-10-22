package booking.dao;

import booking.model.Luggage;
import java.util.List;
import java.util.Optional;

public interface LuggageDAO {

    void create(Luggage luggage);

    Optional<Luggage> findById(Integer luggageId);

    List<Luggage> getAll();

    void update(Luggage luggage);

    void delete(Integer luggageId);

    void deleteAll();
}
