package booking.mybatis.factory;


public class AbstractBookingFactory {
    public Factory getFactory(String choice){
        return switch (choice) {
            case "Booking" -> new BookingFactory();
            case "User" -> new UserFactory();
            case "Airport" -> new AirportFactory();
            case "Airline" -> new AirlineFactory();
            case "Flight" -> new FlightFactory();
            default -> null;
        };
    }
}
