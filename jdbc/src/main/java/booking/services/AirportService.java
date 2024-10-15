package booking.services;

import booking.dao.AirportDAO;
import booking.exception.DAOException;
import booking.factory.DAOFactory;
import booking.model.Airport;


import java.util.List;
import java.util.Optional;

public class AirportService {

    private final AirportDAO airportDAO;

    public AirportService(DAOFactory daoFactory) throws DAOException {
        this.airportDAO = daoFactory.getAirportDAO();
    }

    public void createAirport(Airport airport) {
        airportDAO.insert(airport);
    }

    public Optional<Airport> getAirportById(int id) {
        return airportDAO.findById(id);
    }

    public List<Airport> getAllAirports() {
        return airportDAO.findAll();
    }

    public void updateAirport(Airport airport) {
        airportDAO.update(airport);
    }

    public void deleteAirport(int id) {
        airportDAO.delete(id);
    }

    public void deleteAllAirports() {
        airportDAO.deleteAll();
    }
}
