package src.Repository;

import java.util.List;

public interface Repository<T extends Identifiable<ID>, ID> {
    List<T> getAll();
    void add(T entity);
    void update(T entity);
    void delete(ID id);
    T getById(ID id);
}
