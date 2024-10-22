package booking.parsers.parser;

import booking.model.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class XMLParser {

    public User parseUserXML(String xmlPath) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(User.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        return (User) unmarshaller.unmarshal(new File(xmlPath));
    }

    public Airline parseAirlineXML(String xmlPath) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Airline.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        return (Airline) unmarshaller.unmarshal(new File(xmlPath));
    }

    public Flight parseFlightXML(String xmlPath) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Flight.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        return (Flight) unmarshaller.unmarshal(new File(xmlPath));
    }

    public Passenger parsePassengerXML(String xmlPath) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Passenger.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        return (Passenger) unmarshaller.unmarshal(new File(xmlPath));
    }

    public Booking parseBookingXML(String xmlPath) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Booking.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        return (Booking) unmarshaller.unmarshal(new File(xmlPath));
    }

    public Object parseXML(String xmlPath, String className) throws JAXBException {
        return switch (className) {
            case "user" -> parseUserXML(xmlPath);
            case "airline" -> parseAirlineXML(xmlPath);
            case "flight" -> parseFlightXML(xmlPath);
            case "passenger" -> parsePassengerXML(xmlPath);
            case "booking" -> parseBookingXML(xmlPath);
            default -> null;
        };
    }
}
