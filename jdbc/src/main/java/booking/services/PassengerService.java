package booking.services;

import booking.dao.PassengerDAO;
import booking.dao.jdbc.MySQLPassengerDAO;
import booking.exception.DAOException;
import booking.factory.DAOFactory;
import booking.model.Passenger;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class PassengerService {

    private final PassengerDAO passengerDAO;

    public PassengerService(DAOFactory daoFactory) throws DAOException {
        this.passengerDAO = daoFactory.getPassengerDAO();
    }

    public PassengerService() {
        this.passengerDAO = new MySQLPassengerDAO();
    }

    public void createPassenger(Passenger passenger) throws SQLException {
        passengerDAO.create(passenger);
    }

    public Optional<Passenger> getPassenger(Integer id) {
        return passengerDAO.findById(id);
    }

    public void updatePassenger(Passenger passenger) throws SQLException {
        passengerDAO.update(passenger);
    }

    public void deletePassenger(Integer passengerId) {
        passengerDAO.delete(passengerId);
    }

    public List<Passenger> getAllPassengers() {
        return passengerDAO.getAll();
    }

    public void deleteAllPassengers() {
        passengerDAO.deleteAll();
    }
}
