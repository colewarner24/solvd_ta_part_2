package booking.model;

import java.util.Objects;

public class FlightPricing {
    private Integer id;
    private Integer flightId;
    private Double price;
    private String flightClass;

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
