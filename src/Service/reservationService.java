// service/ReservationService.java
package src.Service;

import src.Domain.Reservation;
import src.Repository.idGenerator;
import src.Repository.reservationRepository;

import java.util.List;

public class reservationService {
    private reservationRepository reservationRepository;
    private idGenerator idGenerator;

    public reservationService(reservationRepository reservationRepository, idGenerator idGenerator) {
        this.reservationRepository = reservationRepository;
        this.idGenerator = idGenerator;
    }

    public List<Reservation> getAllReservations() {
        return reservationRepository.getAll();
    }

    public void createReservation(Reservation reservation) {
        validateReservation(reservation);
        reservationRepository.add(Reservation.createWithGeneratedId(reservation.getCarId(), reservation.getCustomerName(), idGenerator));
    }

    public void cancelReservation(int reservationId) {
        reservationRepository.delete(reservationId);
    }

    public Reservation getReservationById(int reservationId) {
        return reservationRepository.getById(reservationId);
    }

    private void validateReservation(Reservation reservation) {
        if (reservation.getCarId() == null || reservation.getCustomerName() == null || reservation.getCustomerName().isEmpty()) {
            throw new IllegalArgumentException("Car ID and customer name cannot be empty.");
        }
    }
}
