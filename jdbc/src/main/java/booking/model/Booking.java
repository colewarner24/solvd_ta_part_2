package booking.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.xml.bind.annotation.*;
import java.sql.Timestamp;

@XmlRootElement(name="booking")
@XmlAccessorType(XmlAccessType.FIELD)
@JsonPropertyOrder({"id", "userId", "flightId", "bookingDate", "checkedIn"})
public class Booking {

    @XmlElement
    @JsonProperty("id")
    private Integer id;

    @XmlElement
    @JsonProperty("userId")
    private Integer userId;

    @XmlElement
    @JsonProperty("flightId")
    private Integer flightId;

    @XmlElement
    @XmlSchemaType(name = "dateTime")
    @JsonProperty("bookingDate")
    private String bookingDate;

    @XmlElement
    @JsonProperty("checkedIn")
    private Boolean checkedIn;

    public Booking() {}

    public Booking(Integer id, Integer userId, Integer flightId, String bookingDate, Boolean checkedIn) {
        this.id = id;
        this.userId = userId;
        this.flightId = flightId;
        this.bookingDate = bookingDate;
        this.checkedIn = checkedIn;
    }

    public Booking(Integer userId, Integer flightId, String bookingDate, Boolean checkedIn) {
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

    public String getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(String bookingDate) {
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
