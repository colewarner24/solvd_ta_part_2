package booking.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Objects;

@XmlRootElement(name="flightPricing")
@XmlAccessorType(XmlAccessType.FIELD)
@JsonPropertyOrder({"id", "flightId", "price", "flightClass"})
public class FlightPricing {

    @XmlElement
    @JsonProperty("id")
    private Integer id;

    @XmlElement
    @JsonProperty("flightId")
    private Integer flightId;

    @XmlElement
    @JsonProperty("price")
    private Double price;

    @XmlElement
    @JsonProperty("flightClass")
    private String flightClass;

    public FlightPricing() {}

    public FlightPricing(Integer id, Integer flightId, Double price, String flightClass) {
        this.id = id;
        this.flightId = flightId;
        this.price = price;
        this.flightClass = flightClass;
    }

    public FlightPricing(Integer flightId, Double price, String flightClass) {
        this.flightId = flightId;
        this.price = price;
        this.flightClass = flightClass;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getFlightClass() {
        return flightClass;
    }

    public void setFlightClass(String flightClass) {
        this.flightClass = flightClass;
    }

    public String toString() {
        return "FlightPricing{" +
                "id=" + id +
                ", flightId=" + flightId +
                ", price=" + price +
                ", flightClass='" + flightClass + '\'' +
                '}';
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FlightPricing that = (FlightPricing) o;

        if (!Objects.equals(id, that.id)) return false;
        if (!Objects.equals(flightId, that.flightId)) return false;
        if (!Objects.equals(price, that.price)) return false;
        return Objects.equals(flightClass, that.flightClass);
    }
}
