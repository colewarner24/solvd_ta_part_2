package booking.model;

import java.util.Objects;

public class Seat {
    private Integer id;
    private Integer flightId;
    private String seatNumber;
    private String seatClass;
    private boolean available;

    public Seat(Integer id, Integer flightId, String seatNumber, String seatClass, boolean available) {
        this.id = id;
        this.flightId = flightId;
        this.seatNumber = seatNumber;
        this.seatClass = seatClass;
        this.available = available;
    }

    public Seat(Integer flightId, String seatNumber, String seatClass, boolean available) {
        this.flightId = flightId;
        this.seatNumber = seatNumber;
        this.seatClass = seatClass;
        this.available = available;
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFlightId() {
        return flightId;
    }

    public void setFlightId(Integer flightId) {
        this.flightId = flightId;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getSeatClass() {
        return seatClass;
    }

    public void setSeatClass(String seatClass) {
        this.seatClass = seatClass;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Seat)) return false;
        Seat seat = (Seat) o;
        return available == seat.available &&
                Objects.equals(id, seat.id) &&
                Objects.equals(flightId, seat.flightId) &&
                Objects.equals(seatNumber, seat.seatNumber) &&
                Objects.equals(seatClass, seat.seatClass);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, flightId, seatNumber, seatClass, available);
    }

    @Override
    public String toString() {
        return "Seat{" +
                "id=" + id +
                ", flightId=" + flightId +
                ", seatNumber='" + seatNumber + '\'' +
                ", seatClass='" + seatClass + '\'' +
                ", available=" + available +
                '}';
    }
}
