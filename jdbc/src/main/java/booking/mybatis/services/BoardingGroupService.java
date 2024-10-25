package booking.mybatis.services;

import booking.model.BoardingGroup;
import booking.mybatis.mappers.BoardingGroupMapper;

public class BoardingGroupService extends BaseService<BoardingGroup, Integer, BoardingGroupMapper> {

    @Override
    protected Class<BoardingGroupMapper> getMapperClass() {
        return BoardingGroupMapper.class;
    }
}
