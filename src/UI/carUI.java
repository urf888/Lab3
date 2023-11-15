
package src.UI;

import src.Domain.Car;
import src.Service.carService;

import java.util.List;
import java.util.Scanner;

public class carUI {
    private carService carService;
    private Scanner scanner;

    public carUI(carService carService) {
        this.carService = carService;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        int choice;
        do {
            System.out.println("1. Show all cars");
            System.out.println("2. Add a new car");
            System.out.println("3. Update a car");
            System.out.println("4. Delete a car");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            System.out.println("=======================");
            choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    showAllCars();
                    System.out.println("=======================");
                    break;
                case 2:
                    addCar();
                    System.out.println("=======================");
                    break;
                case 3:
                    updateCar();
                    System.out.println("=======================");
                    break;
                case 4:
                    deleteCar();
                    System.out.println("=======================");
                    break;
                case 5:
                    System.out.println("Exiting Car Management...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);
    }

    private void showAllCars() {
        List<Car> cars = carService.getAllCars();
        for (Car car : cars) {
            System.out.println(car.getId() + ": " + car.getBrand() + " " + car.getModel());
        }
    }

    private void addCar() {
        System.out.print("Enter car brand: ");
        String brand = scanner.nextLine();
        System.out.print("Enter car model: ");
        String model = scanner.nextLine();

        Car car = new Car();
        car.setBrand(brand);
        car.setModel(model);

        try {
            carService.addCar(car);
            System.out.println("Car added successfully!");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void updateCar() {
        System.out.print("Enter car ID to update: ");
        int carId = scanner.nextInt();
        scanner.nextLine();

        Car existingCar = carService.getCarById(carId);
        if (existingCar != null) {
            System.out.print("Enter new car brand (leave empty to keep current): ");
            String newBrand = scanner.nextLine();
            System.out.print("Enter new car model (leave empty to keep current): ");
            String newModel = scanner.nextLine();

            if (!newBrand.isEmpty()) {
                existingCar.setBrand(newBrand);
            }
            if (!newModel.isEmpty()) {
                existingCar.setModel(newModel);
            }

            try {
                carService.updateCar(existingCar);
                System.out.println("Car updated successfully!");
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        } else {
            System.out.println("Car not found.");
        }
    }

    private void deleteCar() {
        System.out.print("Enter car ID to delete: ");
        int carId = scanner.nextInt();
        scanner.nextLine(); 

        try {
            carService.deleteCar(carId);
            System.out.println("Car deleted successfully!");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
