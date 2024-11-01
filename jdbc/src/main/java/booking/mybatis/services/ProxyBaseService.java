package booking.mybatis.services;

import java.util.List;

public class ProxyBaseService<T, ID> implements Service<T, ID> {
    private final BaseService<T, ID, ?> realService;
    private final String userRole;

    public ProxyBaseService(BaseService<T, ID, ?> realService, String userRole) {
        this.realService = realService;
        this.userRole = userRole;
    }

    private boolean hasAdminPrivileges() {
        return "ADMIN".equalsIgnoreCase(userRole);
    }

    @Override
    public void create(T entity) {
        if (hasAdminPrivileges()) {
            realService.create(entity);
        } else {
            System.out.println("Access denied: Only ADMIN users can create entities.");
        }
    }

    @Override
    public T findById(ID id) {
        return realService.findById(id);
    }

    @Override
    public List<T> getAll() {
        return realService.getAll();
    }

    @Override
    public void update(T entity) {
        if (hasAdminPrivileges()) {
            realService.update(entity);
        } else {
            System.out.println("Access denied: Only ADMIN users can update entities.");
        }
    }

    @Override
    public void delete(ID id) {
        if (hasAdminPrivileges()) {
            realService.delete(id);
        } else {
            System.out.println("Access denied: Only ADMIN users can delete entities.");
        }
    }

    @Override
    public void deleteAll() {
        if (hasAdminPrivileges()) {
            realService.deleteAll();
        } else {
            System.out.println("Access denied: Only ADMIN users can delete all entities.");
        }
    }
}
