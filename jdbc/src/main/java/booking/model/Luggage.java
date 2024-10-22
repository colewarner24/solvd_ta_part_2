package booking.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Objects;

@XmlRootElement(name="luggage")
@XmlAccessorType(XmlAccessType.FIELD)
@JsonPropertyOrder({"id", "passengerId", "luggageType"})
public class Luggage {

    @XmlElement
    @JsonProperty("id")
    private Integer id;

    @XmlElement
    @JsonProperty("passengerId")
    private Integer passengerId;

    @XmlElement
    @JsonProperty("luggageType")
    private String luggageType;

    public Luggage() {}

    public Luggage(Integer id, Integer passengerId, String luggageType) {
        this.id = id;
        this.passengerId = passengerId;
        this.luggageType = luggageType;
    }

    public Luggage(Integer passengerId, String luggageType) {
        this.passengerId = passengerId;
        this.luggageType = luggageType;
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

    public String getLuggageType() {
        return luggageType;
    }

    public void setLuggageType(String luggageType) {
        this.luggageType = luggageType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Luggage)) return false;
        Luggage luggage = (Luggage) o;
        return Objects.equals(id, luggage.id) &&
                Objects.equals(passengerId, luggage.passengerId) &&
                Objects.equals(luggageType, luggage.luggageType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, passengerId, luggageType);
    }

    @Override
    public String toString() {
        return "Luggage{" +
                "id=" + id +
                ", passengerId=" + passengerId +
                ", luggageType='" + luggageType + '\'' +
                '}';
    }
}
