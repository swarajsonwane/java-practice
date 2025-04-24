package LD.rentzoomcar.product;

import java.util.Date;

public class Vehicle {

        int vehicleId;
        int vehicleNumber;
        VehicleType vehicleType;
        String companyName;
        String model;
        int kmDriven;
        Date manufacturingDate;
        int average;
        int cc;
        int dailyRentCost;
        int hourlyRentCost;
        int noOfSeats;
        Status status;

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public int getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(int vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getKmDriven() {
        return kmDriven;
    }

    public void setKmDriven(int kmDriven) {
        this.kmDriven = kmDriven;
    }

    public Date getManufacturingDate() {
        return manufacturingDate;
    }

    public void setManufacturingDate(Date manufacturingDate) {
        this.manufacturingDate = manufacturingDate;
    }

    public int getAverage() {
        return average;
    }

    public void setAverage(int average) {
        this.average = average;
    }

    public int getCc() {
        return cc;
    }

    public void setCc(int cc) {
        this.cc = cc;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public int getDailyRentCost() {
        return dailyRentCost;
    }

    public void setDailyRentCost(int dailyRentCost) {
        this.dailyRentCost = dailyRentCost;
    }

    public int getHourlyRentCost() {
        return hourlyRentCost;
    }

    public void setHourlyRentCost(int hourlyRentCost) {
        this.hourlyRentCost = hourlyRentCost;
    }

    public int getNoOfSeats() {
        return noOfSeats;
    }

    public void setNoOfSeats(int noOfSeats) {
        this.noOfSeats = noOfSeats;
    }
}
