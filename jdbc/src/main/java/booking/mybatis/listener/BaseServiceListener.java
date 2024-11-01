package booking.mybatis.listener;

import java.util.ArrayList;
import java.util.List;

public class BaseServiceListener<T> {
    private final List<ServiceListener<T>> listeners = new ArrayList<>();

    public void addListener(ServiceListener<T> listener) {
        listeners.add(listener);
    }

    public void removeListener(ServiceListener<T> listener) {
        listeners.remove(listener);
    }

    public void notifyCreate(T entity) {
        for (ServiceListener<T> listener : listeners) {
            listener.onCreate(entity);
        }
    }

    public void notifyUpdate(T entity) {
        for (ServiceListener<T> listener : listeners) {
            listener.onUpdate(entity);
        }
    }

    public void notifyDelete(T entity) {
        for (ServiceListener<T> listener : listeners) {
            listener.onDelete(entity);
        }
    }
}
