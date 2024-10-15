package booking.services;

import booking.dao.FlightPricingDAO;
import booking.dao.jdbc.MySQLFlightPricingDAO;
import booking.exception.DAOException;
import booking.factory.DAOFactory;
import booking.model.FlightPricing;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class FlightPricingService {

    private final FlightPricingDAO flightPricingDAO;

    public FlightPricingService(DAOFactory daoFactory) throws DAOException {
        this.flightPricingDAO = daoFactory.getFlightPricingDAO();
    }

    public FlightPricingService() {
        this.flightPricingDAO = new MySQLFlightPricingDAO();
    }

    public void createFlightPricing(FlightPricing flightPricing) throws SQLException {
        flightPricingDAO.create(flightPricing);
    }

    public Optional<FlightPricing> getFlightPricing(Integer id) {
        return flightPricingDAO.findById(id);
    }

    public void updateFlightPricing(FlightPricing flightPricing) throws SQLException {
        flightPricingDAO.update(flightPricing);
    }

    public void deleteFlightPricing(Integer flightPricingId) {
        flightPricingDAO.delete(flightPricingId);
    }

    public List<FlightPricing> getAllFlightPricings() {
        return flightPricingDAO.getAll();
    }

    public void deleteAllFlightPricings() {
        flightPricingDAO.deleteAll();
    }
}
