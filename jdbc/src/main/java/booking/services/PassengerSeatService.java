package booking.services;

import booking.dao.PassengerSeatDAO;
import booking.dao.jdbc.MySQLPassengerSeatDAO;
import booking.exception.DAOException;
import booking.factory.DAOFactory;
import booking.model.PassengerSeat;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class PassengerSeatService {

    private final PassengerSeatDAO passengerSeatDAO;

    public PassengerSeatService(DAOFactory daoFactory) throws DAOException {
        this.passengerSeatDAO = daoFactory.getPassengerSeatDAO();
    }

    public PassengerSeatService() {
        this.passengerSeatDAO = new MySQLPassengerSeatDAO();
    }

    public void createPassengerSeat(PassengerSeat passengerSeat) throws SQLException {
        passengerSeatDAO.create(passengerSeat);
    }

    public Optional<PassengerSeat> getPassengerSeat(Integer id) {
        return passengerSeatDAO.findById(id);
    }

    public void updatePassengerSeat(PassengerSeat passengerSeat) throws SQLException {
        passengerSeatDAO.update(passengerSeat);
    }

    public void deletePassengerSeat(Integer passengerSeatId) {
        passengerSeatDAO.delete(passengerSeatId);
    }

    public List<PassengerSeat> getAllPassengerSeats() {
        return passengerSeatDAO.getAll();
    }

    public void deleteAllPassengerSeats() {
        passengerSeatDAO.deleteAll();
    }
}
