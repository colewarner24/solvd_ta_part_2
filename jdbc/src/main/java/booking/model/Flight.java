package booking.model;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Flight {
    private int flightId;
    private int airlineId;
    private int departureAirportId;
    private int arrivalAirportId;
    private String departureTime;
    private String flightNumber;
    private String arrivalTime;

    public Flight(int airlineId, int departureAirportId, int arrivalAirportId, String departureTime, String flightNumber, String arrivalTime) {
        this.airlineId = airlineId;
        this.departureAirportId = departureAirportId;
        this.arrivalAirportId = arrivalAirportId;
        this.departureTime = departureTime;
        this.flightNumber = flightNumber;
        this.arrivalTime = arrivalTime;
    }

    public Flight(int flightId, int airlineId, int departureAirportId, int arrivalAirportId, String departureTime, String flightNumber, String arrivalTime) {
        this.flightId = flightId;
        this.airlineId = airlineId;
        this.departureAirportId = departureAirportId;
        this.arrivalAirportId = arrivalAirportId;
        this.departureTime = departureTime;
        this.flightNumber = flightNumber;
        this.arrivalTime = arrivalTime;
    }

    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    public int getAirlineId() {
        return airlineId;
    }

    public void setAirlineId(int airlineId) {
        this.airlineId = airlineId;
    }

    public int getDepartureAirportId() {
        return departureAirportId;
    }

    public void setDepartureAirportId(int departureAirportId) {
        this.departureAirportId = departureAirportId;
    }

    public int getArrivalAirportId() {
        return arrivalAirportId;
    }

    public void setArrivalAirportId(int arrivalAirportId) {
        this.arrivalAirportId = arrivalAirportId;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Flight flight)) return false;
        return flightId == flight.flightId &&
                airlineId == flight.airlineId &&
                departureAirportId == flight.departureAirportId &&
                arrivalAirportId == flight.arrivalAirportId &&
                departureTime.equals(flight.departureTime) &&
                flightNumber.equals(flight.flightNumber) &&
                arrivalTime.equals(flight.arrivalTime);
    }

    public Integer getId() {
        return flightId;
    }

    private Timestamp convertStringToTimestamp(String timeString) throws ParseException, ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        java.util.Date parsedDate = dateFormat.parse(timeString);
        return new Timestamp(parsedDate.getTime());
    }
}
