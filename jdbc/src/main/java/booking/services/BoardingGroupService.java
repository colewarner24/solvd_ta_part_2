package booking.services;

import booking.dao.BoardingGroupDAO;
import booking.dao.jdbc.MySQLBoardingGroupDAO;
import booking.factory.DAOFactory;
import booking.model.BoardingGroup;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class BoardingGroupService {

    private final BoardingGroupDAO boardingGroupDAO;

    public BoardingGroupService(DAOFactory daoFactory) {
        this.boardingGroupDAO = daoFactory.getBoardingGroupDAO();
    }

    public BoardingGroupService() {
        this.boardingGroupDAO = new MySQLBoardingGroupDAO();
    }

    public void createBoardingGroup(BoardingGroup boardingGroup) throws SQLException {
        boardingGroupDAO.insert(boardingGroup);
    }

    public Optional<BoardingGroup> getBoardingGroup(int id) {
        return boardingGroupDAO.findById(id);
    }

    public List<BoardingGroup> getAllBoardingGroups() {
        return boardingGroupDAO.findAll();
    }

    public void updateBoardingGroup(BoardingGroup boardingGroup) throws SQLException {
        boardingGroupDAO.update(boardingGroup);
    }

    public void deleteBoardingGroup(int id) {
        boardingGroupDAO.delete(id);
    }

    public void deleteAllBoardingGroups() {
        boardingGroupDAO.deleteAll();
    }
}
