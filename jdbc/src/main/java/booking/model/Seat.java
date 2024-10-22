package booking.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Objects;

@XmlRootElement(name="seat")
@XmlAccessorType(XmlAccessType.FIELD)
@JsonPropertyOrder({"id", "flightId", "seatNumber", "seatClass", "available"})
public class Seat {

    @XmlElement
    @JsonProperty("id")
    private Integer id;

    @XmlElement
    @JsonProperty("flightId")
    private Integer flightId;

    @XmlElement
    @JsonProperty("seatNumber")
    private String seatNumber;

    @XmlElement
    @JsonProperty("seatClass")
    private String seatClass;

    @XmlElement
    @JsonProperty("available")
    private boolean available;

    public Seat() {}

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
