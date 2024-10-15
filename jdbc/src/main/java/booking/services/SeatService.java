package booking.services;

import booking.dao.SeatDAO;
import booking.dao.jdbc.MySQLSeatDAO;
import booking.exception.DAOException;
import booking.factory.DAOFactory;
import booking.model.Seat;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class SeatService {

    private final SeatDAO seatDAO;

    public SeatService(DAOFactory daoFactory) throws DAOException {
        this.seatDAO = daoFactory.getSeatDAO();
    }

    public SeatService() {
        this.seatDAO = new MySQLSeatDAO();
    }

    public void createSeat(Seat seat) throws SQLException {
        seatDAO.create(seat);
    }

    public Optional<Seat> getSeat(Integer id) {
        return seatDAO.findById(id);
    }

    public void updateSeat(Seat seat) throws SQLException {
        seatDAO.update(seat);
    }

    public void deleteSeat(Integer seatId) {
        seatDAO.delete(seatId);
    }

    public List<Seat> getAllSeats() {
        return seatDAO.getAll();
    }

    public void deleteAllSeats() {
        seatDAO.deleteAll();
    }
}
