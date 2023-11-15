
package src.Domain;

import src.Repository.idGenerator;
import src.Repository.Identifiable;

public class Car implements Identifiable<Integer> {
    private Integer id;
    private String brand;
    private String model;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public static Car createWithGeneratedId(String brand, String model, idGenerator idGenerator) {
        Car car = new Car();
        car.setBrand(brand);
        car.setModel(model);
        car.setId(idGenerator.generateId());
        return car;
    }
}
