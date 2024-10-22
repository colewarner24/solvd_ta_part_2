package booking.services;

import booking.dao.AirlinesDAO;
import booking.dao.jdbc.MySQLAirlinesDAO;
import booking.exception.DAOException;
import booking.factory.DAOFactory;
import booking.model.Airline;

import java.sql.SQLException;
import java.util.List;

public class AirlineService {

    private final AirlinesDAO airlinesDAO;

    public AirlineService(DAOFactory daoFactory) throws DAOException {
        this.airlinesDAO = daoFactory.getAirlinesDAO();
    }

    public AirlineService() {
        this.airlinesDAO = new MySQLAirlinesDAO();
    }

    public void createAirline(Airline airline) throws SQLException {
        airlinesDAO.create(airline);
    }

    public Airline getAirline(Integer id) {
        return airlinesDAO.findById(id);
    }

    public void updateAirline(Airline airline) throws SQLException {
        airlinesDAO.update(airline);
    }

    public void deleteAirline(Integer airlineId) {
        airlinesDAO.delete(airlineId);
    }

    public List<Airline> getAllAirlines() {
        return airlinesDAO.getAll();
    }

    public void deleteAllAirlines() {
        airlinesDAO.deleteAll();
    }
}