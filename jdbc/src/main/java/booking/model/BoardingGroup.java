package booking.model;

import java.util.Objects;

public class BoardingGroup {

    private int boardingGroupId;
    private int flightId;
    private String group;
    private int position;

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
