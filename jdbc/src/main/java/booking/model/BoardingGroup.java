package booking.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Objects;

@XmlRootElement(name="boardingGroup")
@XmlAccessorType(XmlAccessType.FIELD)
@JsonPropertyOrder({"boardingGroupId", "flightId", "group", "position"})
public class BoardingGroup {

    @XmlElement
    @JsonProperty("boardingGroupId")
    private int boardingGroupId;

    @XmlElement
    @JsonProperty("flightId")
    private int flightId;

    @XmlElement
    @JsonProperty("group")
    private String group;

    @XmlElement
    @JsonProperty("position")
    private int position;

    public BoardingGroup() {}

    public BoardingGroup(int boardingGroupId, int flightId, String group, int position) {
        this.boardingGroupId = boardingGroupId;
        this.flightId = flightId;
        this.group = group;
        this.position = position;
    }

    public BoardingGroup(int flightId, String group, int position) {
        this.flightId = flightId;
        this.group = group;
        this.position = position;
    }

    public int getId() {
        return boardingGroupId;
    }

    public void setId(int boardingGroupId) {
        this.boardingGroupId = boardingGroupId;
    }

    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "BoardingGroup{" +
                "boardingGroupId=" + boardingGroupId +
                ", flightId=" + flightId +
                ", group='" + group + '\'' +
                ", position=" + position +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BoardingGroup that = (BoardingGroup) o;
        return boardingGroupId == that.boardingGroupId &&
                flightId == that.flightId &&
                position == that.position &&
                Objects.equals(group, that.group);
    }

    @Override
    public int hashCode() {
        return Objects.hash(boardingGroupId, flightId, group, position);
    }
}
