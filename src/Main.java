package src;

import src.UI.carUI;
import src.UI.reservationUI;
import src.Domain.Car;
import src.Repository.*;
import src.Service.carService;
import src.Service.reservationService;

public class Main {
    public static void main(String[] args) {
        
        idGenerator carIdGenerator = new defaultIdGen();
        carRepository carRepository = new memoryCarRepository(carIdGenerator);
        carService carService = new carService(carRepository, carIdGenerator);
        carUI carUI = new carUI(carService);

        
        idGenerator reservationIdGenerator = new defaultIdGen();
        reservationRepository reservationRepository = new memoryReservationRepository(reservationIdGenerator);
        reservationService reservationService = new reservationService(reservationRepository, reservationIdGenerator);
        reservationUI reservationUI = new reservationUI(reservationService);

        System.out.println("### Car Rental Application ###");
        carUI.start();

        
        System.out.println("\n### Reservation Management ###");
        reservationUI.start();
    }
}
