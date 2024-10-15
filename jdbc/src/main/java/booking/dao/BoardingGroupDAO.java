package booking.dao;

import booking.model.BoardingGroup;

import java.util.List;
import java.util.Optional;

public interface BoardingGroupDAO extends GenericDAO {

    void insert(BoardingGroup boardingGroup);

    Optional<BoardingGroup> findById(Integer id);

    List<BoardingGroup> findAll();

    void update(BoardingGroup boardingGroup);

}
