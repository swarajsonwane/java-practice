package LD.rentzoomcar;

import LD.rentzoomcar.product.Vehicle;

import java.util.Date;

public class Reservation {
    int reservationId;
    User user;
    Vehicle vehicle;
    Date bookingDate;
    Date startDate;
    Date endDate;
    Long fromTimeStamp;
    Long toTimeStamp;
    Location pickupLocation;
    Location dropLocation;
    ReservationType reservationType;
    ReservartionStatus reservartionStatus;
    Location currentLocation;


    public int createReserve(Vehicle vehicle, User user) {
        this.vehicle = vehicle;
        this.user = user;
        this.reservationType = ReservationType.DAILY;
        this.reservartionStatus = ReservartionStatus.SCHEDULED;
        this.reservationId = 1222;

        return reservationId;
    }

    //CRUD operations
    public void cancelReservation() {
        this.reservartionStatus = ReservartionStatus.CANCELLED;
    }


    public void completeReservation() {
        this.reservartionStatus = ReservartionStatus.COMPLETED;
    }


}
