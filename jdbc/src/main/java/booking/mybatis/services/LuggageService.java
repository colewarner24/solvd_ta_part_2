package booking.mybatis.services;

import booking.model.Luggage;
import booking.mybatis.mappers.LuggageMapper;

public class LuggageService extends BaseService<Luggage, Integer, LuggageMapper> {

    @Override
    protected Class<LuggageMapper> getMapperClass() {
        return LuggageMapper.class;
    }
}
