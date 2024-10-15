package booking.model;

import java.sql.Timestamp;

public class Booking {
    private Integer id;
    private Integer userId;
    private Integer flightId;
    private Timestamp bookingDate;
    private Boolean checkedIn;

    public Booking(Integer id, Integer userId, Integer flightId, Timestamp bookingDate, Boolean checkedIn) {
        this.id = id;
        this.userId = userId;
        this.flightId = flightId;
        this.bookingDate = bookingDate;
        this.checkedIn = checkedIn;
    }

    public Booking(Integer userId, Integer flightId, Timestamp bookingDate, Boolean checkedIn) {
        this.userId = userId;
        this.flightId = flightId;
        this.bookingDate = bookingDate;
        this.checkedIn = checkedIn;
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getFlightId() {
        return flightId;
    }

    public void setFlightId(Integer flightId) {
        this.flightId = flightId;
    }

    public Timestamp getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Timestamp bookingDate) {
        this.bookingDate = bookingDate;
    }

    public Boolean getCheckedIn() {
        return checkedIn;
    }

    public void setCheckedIn(Boolean checkedIn) {
        this.checkedIn = checkedIn;
    }

    public String toString() {
        return "Booking{" +
                "id=" + id +
                ", userId=" + userId +
                ", flightId=" + flightId +
                ", bookingDate=" + bookingDate +
                ", checkedIn=" + checkedIn +
                '}';
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Booking booking = (Booking) obj;
        return id.equals(booking.id) &&
                userId.equals(booking.userId) &&
                flightId.equals(booking.flightId) &&
                bookingDate.equals(booking.bookingDate) &&
                checkedIn.equals(booking.checkedIn);
    }
}
