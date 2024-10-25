package booking.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.sql.Timestamp;
import java.util.Objects;

@XmlRootElement(name="payment")
@XmlAccessorType(XmlAccessType.FIELD)
@JsonPropertyOrder({"id", "bookingId", "amount", "paymentDate"})
public class Payment {

    long toleranceInMillis = 10000;

    @XmlElement
    @JsonProperty("id")
    private Integer id;

    @XmlElement
    @JsonProperty("bookingId")
    private Integer bookingId;

    @XmlElement
    @JsonProperty("amount")
    private Double amount;

    @XmlElement
    @JsonProperty("paymentDate")
    private Timestamp paymentDate;

    public Payment() {}

    public Payment(Integer id, Integer bookingId, Double amount, Timestamp paymentDate) {
        this.id = id;
        this.bookingId = bookingId;
        this.amount = amount;
        this.paymentDate = paymentDate;
    }

    public Payment(Integer bookingId, Double amount, Timestamp paymentDate) {
        this.bookingId = bookingId;
        this.amount = amount;
        this.paymentDate = paymentDate;
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

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Timestamp getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Timestamp paymentDate) {
        this.paymentDate = paymentDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Payment)) return false;
        Payment payment = (Payment) o;
        return Objects.equals(id, payment.id) &&
                Objects.equals(bookingId, payment.bookingId) &&
                Objects.equals(amount, payment.amount) &&
                (Math.abs(paymentDate.getTime() - payment.paymentDate.getTime()) <= toleranceInMillis);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, bookingId, amount, paymentDate);
    }

    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                ", bookingId=" + bookingId +
                ", amount=" + amount +
                ", paymentDate=" + paymentDate +
                '}';
    }
}
