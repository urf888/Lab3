// service/CarService.java
package src.Service;

import src.Domain.Car;
import src.Repository.carRepository;
import src.Repository.idGenerator;

import java.util.List;

public class carService {
    private carRepository carRepository;
    private idGenerator idGenerator;

    public carService(carRepository carRepository, idGenerator idGenerator) {
        this.carRepository = carRepository;
        this.idGenerator = idGenerator;
    }

    public List<Car> getAllCars() {
        return carRepository.getAll();
    }

    public void addCar(Car car) {
        validateCar(car);
        carRepository.add(Car.createWithGeneratedId(car.getBrand(), car.getModel(), idGenerator));
    }

    public void updateCar(Car car) {
        validateCar(car);
        carRepository.update(car);
    }

    public void deleteCar(int carId) {
        carRepository.delete(carId);
    }

    public Car getCarById(int carId) {
        return carRepository.getById(carId);
    }

    private void validateCar(Car car) {
        if (car.getBrand() == null || car.getModel() == null || car.getBrand().isEmpty() || car.getModel().isEmpty()) {
            throw new IllegalArgumentException("Brand and model cannot be empty.");
        }
    }
}
