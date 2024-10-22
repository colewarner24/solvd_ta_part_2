package booking.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Objects;

@XmlRootElement(name="airport")
@XmlAccessorType(XmlAccessType.FIELD)
@JsonPropertyOrder({"airportId", "airportName", "airportCity", "airportCode", "airportCountry"})
public class Airport {

    @XmlElement
    @JsonProperty("airportId")
    private int airportId;


    @XmlElement
    @JsonProperty("airportName")
    private String airportName;

    @XmlElement
    @JsonProperty("airportCity")
    private String airportCity;

    @XmlElement
    @JsonProperty("airportCode")
    private String airportCode;

    @XmlElement
    @JsonProperty("airportCountry")
    private String airportCountry;

    public Airport() {}

    public Airport(int airportId, String airportName, String airportCity, String airportCode, String airportCountry) {
        this.airportId = airportId;
        this.airportName = airportName;
        this.airportCity = airportCity;
        this.airportCode = airportCode;
        this.airportCountry = airportCountry;
    }

    public Airport(String airportName, String airportCity, String airportCode, String airportCountry) {
        this.airportName = airportName;
        this.airportCity = airportCity;
        this.airportCode = airportCode;
        this.airportCountry = airportCountry;
    }

    public int getId() {
        return airportId;
    }

    public void setId(int airportId) {
        this.airportId = airportId;
    }

    public String getName() {
        return airportName;
    }

    public void setName(String airportName) {
        this.airportName = airportName;
    }

    public String getCity() {
        return airportCity;
    }

    public void setCity(String airportCity) {
        this.airportCity = airportCity;
    }

    public String getCode() {
        return airportCode;
    }

    public void setCode(String airportCode) {
        this.airportCode = airportCode;
    }

    public String getCountry() {
        return airportCountry;
    }

    public void setCountry(String airportCountry) {
        this.airportCountry = airportCountry;
    }

    @Override
    public String toString() {
        return "Airport{" +
                "airportId=" + airportId +
                ", airportName='" + airportName + '\'' +
                ", airportCity='" + airportCity + '\'' +
                ", airportCode='" + airportCode + '\'' +
                ", airportCountry='" + airportCountry + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Airport airport = (Airport) o;
        return airportId == airport.airportId &&
                Objects.equals(airportName, airport.airportName) &&
                Objects.equals(airportCity, airport.airportCity) &&
                Objects.equals(airportCode, airport.airportCode) &&
                Objects.equals(airportCountry, airport.airportCountry);
    }

    @Override
    public int hashCode() {
        return Objects.hash(airportId, airportName, airportCity, airportCode, airportCountry);
    }
}
