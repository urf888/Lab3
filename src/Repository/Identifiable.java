package src.Repository;

public interface Identifiable<T> {
    T getId();
    void setId(Integer integer);
}