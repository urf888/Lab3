// domain/Reservation.java
package src.Domain;

import src.Repository.idGenerator;
import src.Repository.Identifiable;

public class Reservation implements Identifiable<Integer> {
    private Integer id;
    private Integer carId;
    private String customerName;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public static Reservation createWithGeneratedId(Integer carId, String customerName, idGenerator idGenerator) {
        Reservation reservation = new Reservation();
        reservation.setCarId(carId);
        reservation.setCustomerName(customerName);
        reservation.setId(idGenerator.generateId());
        return reservation;
    }
}
