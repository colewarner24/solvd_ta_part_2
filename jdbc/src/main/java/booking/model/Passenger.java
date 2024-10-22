package booking.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Objects;

@XmlRootElement(name="passenger")
@XmlAccessorType(XmlAccessType.FIELD)
@JsonPropertyOrder({"id", "bookingId", "userId"})
public class Passenger {

    @XmlElement
    @JsonProperty("id")
    private Integer id;

    @XmlElement
    @JsonProperty("bookingId")
    private Integer bookingId;

    @XmlElement
    @JsonProperty("userId")
    private Integer userId;

    public Passenger() {}

    public Passenger(Integer id, Integer bookingId, Integer userId) {
        this.id = id;
        this.bookingId = bookingId;
        this.userId = userId;
    }

    public Passenger(Integer bookingId, Integer userId) {
        this.bookingId = bookingId;
        this.userId = userId;
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBookingId() {
        return bookingId;
    }

    public void setBookingId(Integer bookingId) {
        this.bookingId = bookingId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Passenger)) return false;
        Passenger passenger = (Passenger) o;
        return Objects.equals(id, passenger.id) &&
                Objects.equals(bookingId, passenger.bookingId) &&
                Objects.equals(userId, passenger.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, bookingId, userId);
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "id=" + id +
                ", bookingId=" + bookingId +
                ", userId=" + userId +
                '}';
    }
}
