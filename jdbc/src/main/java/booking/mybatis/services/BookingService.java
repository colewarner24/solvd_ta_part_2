package booking.mybatis.services;

import booking.model.Booking;
import booking.mybatis.mappers.BookingMapper;

public class BookingService extends BaseService<Booking, Integer, BookingMapper> {

    @Override
    protected Class<BookingMapper> getMapperClass() {
        return BookingMapper.class;
    }
}
