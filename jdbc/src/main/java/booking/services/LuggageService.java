package booking.services;

import booking.dao.LuggageDAO;
import booking.dao.jdbc.MySQLLuggageDAO;
import booking.exception.DAOException;
import booking.factory.DAOFactory;
import booking.model.Luggage;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class LuggageService {

    private final LuggageDAO luggageDAO;

    public LuggageService(DAOFactory daoFactory) throws DAOException {
        this.luggageDAO = daoFactory.getLuggageDAO();
    }

    public LuggageService() {
        this.luggageDAO = new MySQLLuggageDAO();
    }

    public void createLuggage(Luggage luggage) throws SQLException {
        luggageDAO.create(luggage);
    }

    public Optional<Luggage> getLuggage(Integer id) {
        return luggageDAO.findById(id);
    }

    public void updateLuggage(Luggage luggage) throws SQLException {
        luggageDAO.update(luggage);
    }

    public void deleteLuggage(Integer luggageId) {
        luggageDAO.delete(luggageId);
    }

    public List<Luggage> getAllLuggages() {
        return luggageDAO.getAll();
    }

    public void deleteAllLuggages() {
        luggageDAO.deleteAll();
    }
}