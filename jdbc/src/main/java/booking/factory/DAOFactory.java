package booking.factory;

import booking.constant.ProjectConstant.FactoryType;
import booking.dao.*;

public abstract class DAOFactory {


    public static DAOFactory getDAOFactory(FactoryType whichFactory) {
        switch (whichFactory) {
            case MYSQL:
                return new MySQLDAOFactory();
            case ORACLE:
                return null;
            case POSTGRESQL:
                return null;
        }
        return null;
    }

    public abstract UserDAO getUserDAO();

    public abstract AirlinesDAO getAirlinesDAO();

    public abstract AirportDAO getAirportDAO();

    public abstract BoardingGroupDAO getBoardingGroupDAO();

    public abstract FlightDAO getFlightDAO();

    public abstract BookingDAO getBookingDAO();

    public abstract FlightPricingDAO getFlightPricingDAO();

    public abstract LuggageDAO getLuggageDAO();

    public abstract PassengerDAO getPassengerDAO();

    public abstract PassengerSeatDAO getPassengerSeatDAO();

    public abstract PaymentDAO getPaymentDAO();

    public abstract SeatDAO getSeatDAO();
}
