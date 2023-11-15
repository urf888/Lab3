package src.UI;

import src.Domain.Reservation;
import src.Service.reservationService;

import java.util.List;
import java.util.Scanner;

public class reservationUI {
    private reservationService reservationService;
    private Scanner scanner;

    public reservationUI(reservationService reservationService) {
        this.reservationService = reservationService;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        int choice;
        do {
            System.out.println("1. Show all reservations");
            System.out.println("2. Create a new reservation");
            System.out.println("3. Cancel a reservation");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            System.out.println("=======================");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    showAllReservations();
                    System.out.println("=======================");
                    break;
                case 2:
                    createReservation();
                    System.out.println("=======================");
                    break;
                case 3:
                    cancelReservation();
                    System.out.println("=======================");
                    break;
                case 4:
                    System.out.println("Exiting Reservation Management...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);
    }

    private void showAllReservations() {
        List<Reservation> reservations = reservationService.getAllReservations();
        for (Reservation reservation : reservations) {
            System.out.println(reservation.getId() + ": CarID=" + reservation.getCarId() +
                    ", Customer=" + reservation.getCustomerName());
        }
    }

    private void createReservation() {
        System.out.print("Enter Car ID: ");
        int carId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Customer Name: ");
        String customerName = scanner.nextLine();

        Reservation reservation = new Reservation();
        reservation.setCarId(carId);
        reservation.setCustomerName(customerName);

        try {
            reservationService.createReservation(reservation);
            System.out.println("Reservation created successfully!");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void cancelReservation() {
        System.out.print("Enter reservation ID to cancel: ");
        int reservationId = scanner.nextInt();
        scanner.nextLine();

        try {
            reservationService.cancelReservation(reservationId);
            System.out.println("Reservation canceled successfully!");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
