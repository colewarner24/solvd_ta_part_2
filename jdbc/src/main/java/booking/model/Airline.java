package booking.model;

import java.util.Objects;

public class Airline {

    private int airlineId;
    private String airlineName;

    public Airline(int airlineId, String airlineName) {
        this.airlineId = airlineId;
        this.airlineName = airlineName;
    }

    public Airline(String airlineName) {
        this.airlineName = airlineName;
    }

    public int getId() {
        return airlineId;
    }

    public void setId(int airlineId) {
        this.airlineId = airlineId;
    }

    public String getName() {
        return airlineName;
    }

    public void setName(String airlineName) {
        this.airlineName = airlineName;
    }

    @Override
    public String toString() {
        return "Airline{" +
                "airlineId=" + airlineId +
                ", airlineName='" + airlineName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Airline airline = (Airline) o;
        return airlineId == airline.airlineId &&
                Objects.equals(airlineName, airline.airlineName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(airlineId, airlineName);
    }
}
