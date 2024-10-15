package booking.model;

import java.util.Objects;

public class Luggage {
    private Integer id;
    private Integer passengerId;
    private String luggageType;

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
