package LD.rentzoomcar;

import LD.rentzoomcar.product.Vehicle;
import LD.rentzoomcar.product.VehicleType;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Vehicle> vehicles = addVehicle();
        List<User> userList = addUsers();

        List<Store> storeList = addStore(vehicles);


        VehicleRentalSystem vehicleRentalSystem = new VehicleRentalSystem(storeList, userList);

        User user = userList.get(0);

        //1. User Search store based on location
        Location location = new Location(403102, "Pune", "Maharashtra", "India");
        Store store = vehicleRentalSystem.getStore(location);

        //Get all vehicles from store based on vehicle type
        List<Vehicle> storeVehicles = store.getVehicles(VehicleType.CAR);

        //Reserving a perticular vehicle
        Vehicle vehicle = storeVehicles.get(0);
        Reservation reservation = store.createReservation(vehicle, user);

        //Create Bill
        Bill bill = new Bill(reservation);

        //Make Payment
        Payment payment = new Payment();
        payment.payBill(bill);

        //Complete Reservation
        store.completeReservation(reservation);
    }

    public static List<Vehicle> addVehicle() {
        List<Vehicle> vehicles = new ArrayList<>();
        Vehicle vehicle = new Vehicle();
        vehicle.setVehicleId(1);
        vehicle.setVehicleType(VehicleType.CAR);
        vehicles.add(vehicle);

        Vehicle vehicle1 = new Vehicle();
        vehicle1.setVehicleId(2);
        vehicle1.setVehicleType(VehicleType.BIKE);
        vehicles.add(vehicle1);

        Vehicle vehicle2 = new Vehicle();
        vehicle2.setVehicleId(3);
        vehicle2.setVehicleType(VehicleType.CAR);
        vehicles.add(vehicle2);

        return vehicles;

    }

    public static List<User> addUsers(){
        List<User> users = new ArrayList<>();
        User user = new User();
        user.setUserId(1);
        user.setUserName(1);
        users.add(user);

        User user1 = new User();
        user1.setUserId(2);
        user1.setUserName(2);
        users.add(user1);

        User user2 = new User();
        user2.setUserId(3);
        user2.setUserName(3);
        users.add(user2);

        return users;
    }

    public static List<Store> addStore(List<Vehicle> vehicles){
        List<Store> storeList = new ArrayList<>();

        Location location = new Location(403102, "Pune", "Maharashtra", "India");

        Store store = new Store();
        store.setStoreId(1);
        store.setVehicles(vehicles);
        store.setLocation(location);
        storeList.add(store);



        return storeList;
    }
}
