package booking.mybatis.services;

import booking.mybatis.mappers.BaseMapper;
import booking.mybatis.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import java.util.List;
import java.util.Objects;

public abstract class BaseService<T, ID, M extends BaseMapper<T, ID>> {

    protected abstract Class<M> getMapperClass(); // Each service will provide its own mapper class.

    public void create(T entity) {
        try (SqlSession session = Objects.requireNonNull(MyBatisUtil.getSqlSessionFactory()).openSession(true)) {
            M mapper = session.getMapper(getMapperClass());
            mapper.create(entity);
            session.commit();
        }
    }

    public T findById(ID id) {
        try (SqlSession session = Objects.requireNonNull(MyBatisUtil.getSqlSessionFactory()).openSession(true)) {
            M mapper = session.getMapper(getMapperClass());
            return mapper.findById(id);
        }
    }

    public List<T> getAll() {
        try (SqlSession session = Objects.requireNonNull(MyBatisUtil.getSqlSessionFactory()).openSession(true)) {
            M mapper = session.getMapper(getMapperClass());
            return mapper.getAll();
        }
    }

    public void update(T entity) {
        try (SqlSession session = Objects.requireNonNull(MyBatisUtil.getSqlSessionFactory()).openSession(true)) {
            M mapper = session.getMapper(getMapperClass());
            mapper.update(entity);
            session.commit();
        }
    }

    public void delete(ID id) {
        try (SqlSession session = Objects.requireNonNull(MyBatisUtil.getSqlSessionFactory()).openSession(true)) {
            M mapper = session.getMapper(getMapperClass());
            mapper.delete(id);
            session.commit();
        }
    }

    public void deleteAll() {
        try (SqlSession session = Objects.requireNonNull(MyBatisUtil.getSqlSessionFactory()).openSession(true)) {
            M mapper = session.getMapper(getMapperClass());
            mapper.deleteAll();
        }
    }
}
