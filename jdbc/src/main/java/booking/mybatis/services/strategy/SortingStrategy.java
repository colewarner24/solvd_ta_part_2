package booking.mybatis.services.strategy;

import java.util.List;

public interface SortingStrategy<T> {
    List<T> sort(List<T> items);
}
