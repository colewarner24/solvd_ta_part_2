package booking.factory;

import booking.dao.*;
import booking.dao.jdbc.*;

public class MySQLDAOFactory extends DAOFactory {

    public static DAOFactory getDAOFactory() {
        return new MySQLDAOFactory();
    }

    @Override
    public UserDAO getUserDAO() {
        return new MySQLUserDAO();
    }

    @Override
    public AirlinesDAO getAirlinesDAO() {
        return new MySQLAirlinesDAO();
    }

    @Override
    public AirportDAO getAirportDAO() {
        return new MySQLAirportDAO();
    }

    @Override
    public BoardingGroupDAO getBoardingGroupDAO() {
        return new MySQLBoardingGroupDAO();
    }

    @Override
    public FlightDAO getFlightDAO() {
        return new MySQLFlightDAO();
    }

    @Override
    public BookingDAO getBookingDAO() {
        return new MySQLBookingsDAO();
    }

    @Override
    public FlightPricingDAO getFlightPricingDAO() {
        return new MySQLFlightPricingDAO();
    }

    @Override
    public LuggageDAO getLuggageDAO() {
        return new MySQLLuggageDAO();
    }

    @Override
    public PassengerDAO getPassengerDAO() {
        return new MySQLPassengerDAO();
    }

    @Override
    public PassengerSeatDAO getPassengerSeatDAO() {
        return new MySQLPassengerSeatDAO();
    }

    @Override
    public PaymentDAO getPaymentDAO() {
        return new MySQLPaymentDAO();
    }

    @Override
    public SeatDAO getSeatDAO() {
        return new MySQLSeatDAO();
    }
}
