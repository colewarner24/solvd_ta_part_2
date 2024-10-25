package mybatis;

import booking.model.BoardingGroup;
import booking.mybatis.services.BoardingGroupService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BoardingGroupTest {

    private BoardingGroup boardingGroup1;
    private BoardingGroupService boardingGroupService;

    @Before
    public void setUp() {
        boardingGroupService = new BoardingGroupService();
        boardingGroup1 = new BoardingGroup(5, "A", 10);
        boardingGroupService.create(boardingGroup1);
    }

    @Test
    public void testCreateBoardingGroup() {
        BoardingGroup db_boardingGroup = boardingGroupService.findById(boardingGroup1.getId());
        assert boardingGroup1.equals(db_boardingGroup);
    }

    @Test
    public void updateBoardingGroup() {
        BoardingGroup boardingGroupUpdate = new BoardingGroup(boardingGroup1.getId(), 5, "B", 5);  // Updating group and position
        boardingGroupService.update(boardingGroupUpdate);
        BoardingGroup db_boardingGroup = boardingGroupService.findById(boardingGroup1.getId());
        assert boardingGroupUpdate.equals(db_boardingGroup);
    }

    @Test
    public void deleteBoardingGroup() {
        boardingGroupService.delete(boardingGroup1.getId());
        BoardingGroup db_boardingGroup = boardingGroupService.findById(boardingGroup1.getId());
        assert db_boardingGroup == null;
    }

    @After
    public void tearDown() {
        boardingGroupService.delete(boardingGroup1.getId());
    }
}
