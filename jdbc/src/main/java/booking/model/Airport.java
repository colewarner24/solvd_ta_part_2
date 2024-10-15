package booking.model;

import java.util.Objects;

public class Airport {

    private int airportId;
    private String airportName;
    private String airportCity;
    private String airportCode;
    private String airportCountry;

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
