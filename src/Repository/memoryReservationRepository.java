package src.Repository;

import src.Domain.Reservation;

public class memoryReservationRepository extends MemoryRepository<Reservation, Integer> implements reservationRepository {

    public memoryReservationRepository(src.Repository.idGenerator idGenerator) {
        super(idGenerator);
        //TODO Auto-generated constructor stub
    }
}