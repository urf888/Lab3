// repository/MemoryRepository.java
package src.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemoryRepository<T extends Identifiable<ID>, ID> implements Repository<T, ID> {
    private final Map<ID, T> storage = new HashMap<>();
    private final idGenerator idGenerator;

    public MemoryRepository(idGenerator idGenerator) {
        this.idGenerator = idGenerator;
    }

    @Override
    public List<T> getAll() {
        return List.copyOf(storage.values());
    }

    @Override
    public void add(T entity) {
        if (entity.getId() == null) {
            entity.setId(idGenerator.generateId());
        }

        if (storage.containsKey(entity.getId())) {
            throw new IllegalArgumentException("Entity with the same ID already exists.");
        }

        storage.put(entity.getId(), entity);
    }

    @Override
    public void update(T entity) {
        if (!storage.containsKey(entity.getId())) {
            throw new IllegalArgumentException("Entity not found for update.");
        }
        storage.put(entity.getId(), entity);
    }

    @Override
    public void delete(ID id) {
        if (!storage.containsKey(id)) {
            throw new IllegalArgumentException("Entity not found for deletion.");
        }
        storage.remove(id);
    }

    @Override
    public T getById(ID id) {
        return storage.get(id);
    }
}
