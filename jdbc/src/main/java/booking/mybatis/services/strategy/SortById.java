package booking.mybatis.services.strategy;

import booking.model.User;
import java.util.List;
import java.util.Comparator;
import java.util.stream.Collectors;

public class SortById implements SortingStrategy<User> {

    @Override
    public List<User> sort(List<User> users) {
        return users.stream()
                .sorted(Comparator.comparing(User::getId))
                .collect(Collectors.toList());
    }
}