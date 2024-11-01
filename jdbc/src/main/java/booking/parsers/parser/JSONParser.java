package booking.parsers.parser;

import booking.model.*;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class JSONParser implements Parser {

    public User parseUserJSON(String jsonPath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(new File(jsonPath), User.class);
    }

    public Airline parseAirlineJSON(String jsonPath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(new File(jsonPath), Airline.class);
    }

    public Flight parseFlightJSON(String jsonPath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(new File(jsonPath), Flight.class);
    }

    public Passenger parsePassengerJSON(String jsonPath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(new File(jsonPath), Passenger.class);
    }

    public Booking parseBookingJSON(String jsonPath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(new File(jsonPath), Booking.class);
    }

    public Object parse(String jsonPath, String className) throws IOException {
        return switch (className) {
            case "user" -> parseUserJSON(jsonPath);
            case "airline" -> parseAirlineJSON(jsonPath);
            case "flight" -> parseFlightJSON(jsonPath);
            case "passenger" -> parsePassengerJSON(jsonPath);
            case "booking" -> parseBookingJSON(jsonPath);
            default -> null;
        };
    }
}
