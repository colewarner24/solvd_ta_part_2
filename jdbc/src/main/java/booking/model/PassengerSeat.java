package booking.model;

import java.util.Objects;

public class PassengerSeat {
    private Integer id;
    private Integer passengerId;
    private String seatNumber;

    public PassengerSeat(Integer id, Integer passengerId, String seatNumber) {
        this.id = id;
        this.passengerId = passengerId;
        this.seatNumber = seatNumber;
    }

    public PassengerSeat(Integer passengerId, String seatNumber) {
        this.passengerId = passengerId;
        this.seatNumber = seatNumber;
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(Integer passengerId) {
        this.passengerId = passengerId;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PassengerSeat)) return false;
        PassengerSeat that = (PassengerSeat) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(passengerId, that.passengerId) &&
                Objects.equals(seatNumber, that.seatNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, passengerId, seatNumber);
    }

    @Override
    public String toString() {
        return "PassengerSeat{" +
                "id=" + id +
                ", passengerId=" + passengerId +
                ", seatNumber='" + seatNumber + '\'' +
                '}';
    }
}
