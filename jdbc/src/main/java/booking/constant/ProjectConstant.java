package booking.constant;

public final class ProjectConstant {
    private ProjectConstant() {
    }

    public static final String PROPERTY_KEY_NAME = "db";
    public static final String PROPERTY_URL = "url";
    public static final String PROPERTY_USER = "user";
    public static final String PROPERTY_PASSWORD = "password";
    public static final String PROPERTY_DRIVER = "driver";

    public static final String USER_SQL_INSERT = "INSERT INTO user (first_name, last_name, email, password) VALUES (?, ?, ?, ?)";
    public static final String USER_FIND_BY_ID = "SELECT * FROM user WHERE user_id = ?";
    public static final String USER_FIND_ALL = "SELECT * FROM user";
    public static final String USER_UPDATE = "UPDATE user SET first_name = ?, last_name = ?, email = ?, password = ? WHERE user_id = ?";
    public static final String USER_DELETE = "DELETE FROM user WHERE user_id = ?";
    public static final String USER_DELETE_ALL = "DELETE FROM user";

    public static final String AIRLINES_SQL_INSERT = "INSERT INTO airlines (airline_name) VALUES (?)";
    public static final String AIRLINES_FIND_BY_ID = "SELECT * FROM airlines WHERE airline_id = ?";
    public static final String AIRLINES_FIND_ALL = "SELECT * FROM airlines";
    public static final String AIRLINES_UPDATE = "UPDATE airlines SET airline_name = ? WHERE airline_id = ?";
    public static final String AIRLINES_DELETE = "DELETE FROM airlines WHERE airline_id = ?";
    public static final String AIRLINES_DELETE_ALL = "DELETE FROM airlines";

    public static final String AIRPORTS_SQL_INSERT = "INSERT INTO airports (airport_name, airport_city, airport_code, airport_country) VALUES (?, ?, ?, ?)";
    public static final String AIRPORTS_FIND_BY_ID = "SELECT * FROM airports WHERE airport_id = ?";
    public static final String AIRPORTS_FIND_ALL = "SELECT * FROM airports";
    public static final String AIRPORTS_UPDATE = "UPDATE airports SET airport_name = ?, airport_city = ?, airport_code = ?, airport_country = ? WHERE airport_id = ?";
    public static final String AIRPORTS_DELETE = "DELETE FROM airports WHERE airport_id = ?";
    public static final String AIRPORTS_DELETE_ALL = "DELETE FROM airports";

    public static final String BOARDING_GROUP_SQL_INSERT = "INSERT INTO boardinggroup (flight_id, `group`, position) VALUES (?, ?, ?)";
    public static final String BOARDING_GROUP_FIND_BY_ID = "SELECT * FROM boardinggroup WHERE boarding_group_id = ?";
    public static final String BOARDING_GROUP_FIND_ALL = "SELECT * FROM boardinggroup";
    public static final String BOARDING_GROUP_UPDATE = "UPDATE boardinggroup SET flight_id = ?, `group` = ?, position = ? WHERE boarding_group_id = ?";
    public static final String BOARDING_GROUP_DELETE = "DELETE FROM boardinggroup WHERE boarding_group_id = ?";
    public static final String BOARDING_GROUP_DELETE_ALL = "DELETE FROM boardinggroup";

    public static final String BOOKINGS_SQL_INSERT = "INSERT INTO bookings (user_id, flight_id, booking_date, checked_in) VALUES (?, ?, ?, ?)";
    public static final String BOOKINGS_FIND_BY_ID = "SELECT * FROM bookings WHERE booking_id = ?";
    public static final String BOOKINGS_FIND_ALL = "SELECT * FROM bookings";
    public static final String BOOKINGS_UPDATE = "UPDATE bookings SET user_id = ?, flight_id = ?, booking_date = ?, checked_in = ? WHERE booking_id = ?";
    public static final String BOOKINGS_DELETE = "DELETE FROM bookings WHERE booking_id = ?";
    public static final String BOOKINGS_DELETE_ALL = "DELETE FROM bookings";

    public static final String FLIGHT_PRICING_SQL_INSERT = "INSERT INTO flightpricings (flight_id, price, class) VALUES (?, ?, ?)";
    public static final String FLIGHT_PRICING_FIND_BY_ID = "SELECT * FROM flightpricings WHERE flight_pricing_id = ?";
    public static final String FLIGHT_PRICING_FIND_ALL = "SELECT * FROM flightpricings";
    public static final String FLIGHT_PRICING_UPDATE = "UPDATE flightpricings SET flight_id = ?, price = ?, class = ? WHERE flight_pricing_id = ?";
    public static final String FLIGHT_PRICING_DELETE = "DELETE FROM flightpricings WHERE flight_pricing_id = ?";
    public static final String FLIGHT_PRICING_DELETE_ALL = "DELETE FROM flightpricings";

    public static final String FLIGHTS_SQL_INSERT = "INSERT INTO flights (airline_id, departure_airport_id, arrival_airport_id, departure_time, flight_number, arrival_time) VALUES (?, ?, ?, ?, ?, ?)";
    public static final String FLIGHTS_FIND_BY_ID = "SELECT * FROM flights WHERE flight_id = ?";
    public static final String FLIGHTS_FIND_ALL = "SELECT * FROM flights";
    public static final String FLIGHTS_UPDATE = "UPDATE flights SET airline_id = ?, departure_airport_id = ?, arrival_airport_id = ?, departure_time = ?, flight_number = ?, arrival_time = ? WHERE flight_id = ?";
    public static final String FLIGHTS_DELETE = "DELETE FROM flights WHERE flight_id = ?";
    public static final String FLIGHTS_DELETE_ALL = "DELETE FROM flights";

    public static final String LUGGAGE_SQL_INSERT = "INSERT INTO luggage (passenger_id, luggage_type) VALUES (?, ?)";
    public static final String LUGGAGE_FIND_BY_ID = "SELECT * FROM luggage WHERE luggage_id = ?";
    public static final String LUGGAGE_FIND_ALL = "SELECT * FROM luggage";
    public static final String LUGGAGE_UPDATE = "UPDATE luggage SET passenger_id = ?, luggage_type = ? WHERE luggage_id = ?";
    public static final String LUGGAGE_DELETE = "DELETE FROM luggage WHERE luggage_id = ?";
    public static final String LUGGAGE_DELETE_ALL = "DELETE FROM luggage";

    public static final String PASSENGERS_SQL_INSERT = "INSERT INTO passengers (booking_id, user_id) VALUES (?, ?)";
    public static final String PASSENGERS_FIND_BY_ID = "SELECT * FROM passengers WHERE passenger_id = ?";
    public static final String PASSENGERS_FIND_ALL = "SELECT * FROM passengers";
    public static final String PASSENGERS_UPDATE = "UPDATE passengers SET booking_id = ?, user_id = ? WHERE passenger_id = ?";
    public static final String PASSENGERS_DELETE = "DELETE FROM passengers WHERE passenger_id = ?";
    public static final String PASSENGERS_DELETE_ALL = "DELETE FROM passengers";

    public static final String PASSENGER_SEATS_SQL_INSERT = "INSERT INTO passengerseats (passenger_id, seat_number) VALUES (?, ?)";
    public static final String PASSENGER_SEATS_FIND_BY_ID = "SELECT * FROM passengerseats WHERE passenger_seat_id = ?";
    public static final String PASSENGER_SEATS_FIND_ALL = "SELECT * FROM passengerseats";
    public static final String PASSENGER_SEATS_UPDATE = "UPDATE passengerseats SET passenger_id = ?, seat_number = ? WHERE passenger_seat_id = ?";
    public static final String PASSENGER_SEATS_DELETE = "DELETE FROM passengerseats WHERE passenger_seat_id = ?";
    public static final String PASSENGER_SEATS_DELETE_ALL = "DELETE FROM passengerseats";

    public static final String PAYMENTS_SQL_INSERT = "INSERT INTO payments (booking_id, amount, payment_date) VALUES (?, ?, ?)";
    public static final String PAYMENTS_FIND_BY_ID = "SELECT * FROM payments WHERE payment_id = ?";
    public static final String PAYMENTS_FIND_ALL = "SELECT * FROM payments";
    public static final String PAYMENTS_UPDATE = "UPDATE payments SET booking_id = ?, amount = ?, payment_date = ? WHERE payment_id = ?";
    public static final String PAYMENTS_DELETE = "DELETE FROM payments WHERE payment_id = ?";
    public static final String PAYMENTS_DELETE_ALL = "DELETE FROM payments";

    public static final String SEATS_SQL_INSERT = "INSERT INTO seats (flight_id, seat_number, class, available) VALUES (?, ?, ?, ?)";
    public static final String SEATS_FIND_BY_ID = "SELECT * FROM seats WHERE seat_id = ?";
    public static final String SEATS_FIND_ALL = "SELECT * FROM seats";
    public static final String SEATS_UPDATE = "UPDATE seats SET flight_id = ?, seat_number = ?, class = ?, available = ? WHERE seat_id = ?";
    public static final String SEATS_DELETE = "DELETE FROM seats WHERE seat_id = ?";
    public static final String SEATS_DELETE_ALL = "DELETE FROM seats";

    public enum FactoryType {
        MYSQL,
        ORACLE,
        POSTGRESQL
    }
}
