package LD.rentzoomcar;

public class Bill {

    Reservation reservation;
    double amount;
    boolean isPaid;

    Bill(Reservation reservation) {
        this.reservation = reservation;
        this.amount = computeAmount();
        this.isPaid = false;
    }

    private double computeAmount() {
        double amount = 10.0;
//        long duration = reservation.getEndTime() - reservation.getStartTime();
//        if (reservation.getReservationType() == ReservationType.HOURLY) {
//            amount = duration * 1;
//        } else if (reservation.getReservationType() == ReservationType.DAILY) {
//            amount = duration / 24 * 100;
//        }
        return amount;
    }
}
