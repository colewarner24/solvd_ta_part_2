package booking.mybatis.services;

import booking.mybatis.listener.BaseServiceListener;
import booking.mybatis.listener.ServiceListener;
import booking.mybatis.mappers.BaseMapper;
import booking.mybatis.services.strategy.SortingStrategy;
import booking.mybatis.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Objects;

public abstract class BaseService<T, ID, M extends BaseMapper<T, ID>> implements Service<T, ID> {

    private final BaseServiceListener<T> listeners = new BaseServiceListener<>();

    protected abstract Class<M> getMapperClass();

    public void addServiceListener(ServiceListener<T> listener) {
        listeners.addListener(listener);
    }

    public void removeServiceListener(ServiceListener<T> listener) {
        listeners.removeListener(listener);
    }

    @Override
    public void create(T entity) {
        try (SqlSession session = Objects.requireNonNull(MyBatisUtil.getSqlSessionFactory()).openSession(true)) {
            M mapper = session.getMapper(getMapperClass());
            mapper.create(entity);
            session.commit();
        }
    }

    @Override
    public T findById(ID id) {
        try (SqlSession session = Objects.requireNonNull(MyBatisUtil.getSqlSessionFactory()).openSession(true)) {
            M mapper = session.getMapper(getMapperClass());
            return mapper.findById(id);
        }
    }

    @Override
    public List<T> getAll() {
        return getAll(null); // Default call without any sorting strategy.
    }

    public List<T> getAll(SortingStrategy<T> strategy) {
        try (SqlSession session = Objects.requireNonNull(MyBatisUtil.getSqlSessionFactory()).openSession(true)) {
            M mapper = session.getMapper(getMapperClass());
            List<T> items = mapper.getAll();

            // Apply sorting if a strategy is provided
            return (strategy != null) ? strategy.sort(items) : items;
        }
    }

    @Override
    public void update(T entity) {
        try (SqlSession session = Objects.requireNonNull(MyBatisUtil.getSqlSessionFactory()).openSession(true)) {
            M mapper = session.getMapper(getMapperClass());
            mapper.update(entity);
            session.commit();
        }
    }

    @Override
    public void delete(ID id) {
        try (SqlSession session = Objects.requireNonNull(MyBatisUtil.getSqlSessionFactory()).openSession(true)) {
            M mapper = session.getMapper(getMapperClass());
            mapper.delete(id);
            session.commit();
        }
    }

    @Override
    public void deleteAll() {
        try (SqlSession session = Objects.requireNonNull(MyBatisUtil.getSqlSessionFactory()).openSession(true)) {
            M mapper = session.getMapper(getMapperClass());
            mapper.deleteAll();
        }
    }
}
