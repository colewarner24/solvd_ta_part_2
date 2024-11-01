package booking.mybatis.listener;

public interface ServiceListener<T> {
    void onCreate(T entity);
    void onUpdate(T entity);
    void onDelete(T entity);
}
