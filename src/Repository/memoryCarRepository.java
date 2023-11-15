package src.Repository;

import src.Domain.Car;

public class memoryCarRepository extends MemoryRepository<Car, Integer> implements carRepository {

    public memoryCarRepository(src.Repository.idGenerator idGenerator) {
        super(idGenerator);
        //TODO Auto-generated constructor stub
    }
}