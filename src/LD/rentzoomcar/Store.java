package LD.rentzoomcar;

import LD.rentzoomcar.product.Vehicle;
import LD.rentzoomcar.product.VehicleType;

import java.util.ArrayList;
import java.util.List;

public class Store {
    int storeId;
    VehicleInventoryManagement vehicleInventoryManagement;
    Location location;
    List<Reservation> reservations = new ArrayList<>();

    public Store(){
        vehicleInventoryManagement = new VehicleInventoryManagement(new ArrayList<>());
    }

    public List<Vehicle> getVehicles(VehicleType type) {
        return vehicleInventoryManagement.getVehicles();
    }

    public void setVehicles(List<Vehicle> vehicles) {
        vehicleInventoryManagement.setVehicles(vehicles);
    }

    public Reservation createReservation(Vehicle vehicle, User user) {
        Reservation reservation = new Reservation();
        reservation.createReserve(vehicle, user);
        reservations.add(reservation);
        return reservation;
    }

    public void completeReservation(Reservation reservation) {
        reservation.completeReservation();
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setVehicleInventoryManagement(VehicleInventoryManagement vehicleInventoryManagement) {
        this.vehicleInventoryManagement = vehicleInventoryManagement;
    }

    //Update Reservation


}
