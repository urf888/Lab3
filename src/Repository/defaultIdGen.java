package src.Repository;

public class defaultIdGen implements idGenerator {
    private Integer generateIdCounter = 1;

    @Override
    public Integer generateId() {
        return generateIdCounter++;
    }
}