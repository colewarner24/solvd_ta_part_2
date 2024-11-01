package booking.mybatis.controller;

import java.util.List;

public interface Controller<T> {

    void displayAll();

    void create(T entity);

    void delete(int id);

    void update(T entity);

    T findById(int id);
}
