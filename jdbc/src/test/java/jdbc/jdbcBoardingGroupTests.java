package jdbc;

import booking.constant.ProjectConstant.FactoryType;
import booking.exception.DAOException;
import booking.model.BoardingGroup;
import booking.services.BoardingGroupService;
import booking.factory.DAOFactory;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;
import java.util.Optional;

import static org.junit.Assert.assertThrows;

public class jdbcBoardingGroupTests {

    private BoardingGroupService boardingGroupService;
    private BoardingGroup boardingGroup1;

    @Before
    public void setUp() throws DAOException, SQLException {
        this.boardingGroupService = new BoardingGroupService(DAOFactory.getDAOFactory(FactoryType.MYSQL));
        boardingGroupService.deleteAllBoardingGroups();

        boardingGroup1 = new BoardingGroup(1, "C", 3);
        boardingGroupService.createBoardingGroup(boardingGroup1);
    }

    @Test
    public void testCreateBoardingGroup() {
        Optional<BoardingGroup> db_boardingGroup = boardingGroupService.getBoardingGroup(boardingGroup1.getId());
        assert db_boardingGroup.isPresent() && boardingGroup1.equals(db_boardingGroup.get());
    }

    @Test
    public void testUpdateBoardingGroup() throws SQLException {
        BoardingGroup updatedBoardingGroup = new BoardingGroup(boardingGroup1.getId(), "B", 5);
        boardingGroupService.updateBoardingGroup(updatedBoardingGroup);
        Optional<BoardingGroup> db_boardingGroup = boardingGroupService.getBoardingGroup(boardingGroup1.getId());
        assert db_boardingGroup.isPresent() && updatedBoardingGroup.equals(db_boardingGroup.get());
    }

    @Test
    public void testDeleteBoardingGroup() {
        boardingGroupService.deleteBoardingGroup(boardingGroup1.getId());
        assertThrows(DAOException.class, () -> boardingGroupService.getBoardingGroup(boardingGroup1.getId()).orElseThrow(() -> new DAOException("BoardingGroup not found")));
    }

    @Test
    public void testDeleteAllBoardingGroups() {
        boardingGroupService.deleteAllBoardingGroups();
        assert boardingGroupService.getAllBoardingGroups().isEmpty();
    }
}
