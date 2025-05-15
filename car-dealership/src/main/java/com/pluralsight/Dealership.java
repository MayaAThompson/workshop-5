package com.pluralsight;

import java.util.ArrayList;

public class Dealership {

    private String name;
    private String address;
    private String phoneNumber;

    private ArrayList<Vehicle> inventory;

    public Dealership(String name, String address, String phoneNumber) {
        inventory = new ArrayList<>();
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public ArrayList<Vehicle> getVehiclesByPrice(double min, double max) {
        ArrayList<Vehicle> priceFilteredVehicles = new ArrayList<>();
        for (Vehicle vehicle : inventory) {
            if (vehicle.getPrice() >= min && vehicle.getPrice() <= max) {
                priceFilteredVehicles.add(vehicle);
            }
        }
        return priceFilteredVehicles;
    }

    public ArrayList<Vehicle> getVehiclesByMakeModel(String make, String model) {
        ArrayList<Vehicle> makeModelFilteredVehicles = new ArrayList<>();
        for (Vehicle vehicle : inventory) {
            if (make.equalsIgnoreCase(vehicle.getMake()) || model.equalsIgnoreCase(vehicle.getModel())) {
                makeModelFilteredVehicles.add(vehicle);
            }
        }
        return makeModelFilteredVehicles;
    }

    public ArrayList<Vehicle> getVehiclesByYear(int min, int max) {
        ArrayList<Vehicle> yearFilteredVehicles = new ArrayList<>();
        for (Vehicle vehicle : inventory) {
            if (vehicle.getYear() >= min && vehicle.getYear() <= max) {
                yearFilteredVehicles.add(vehicle);
            }
        }
        return yearFilteredVehicles;
    }

    public ArrayList<Vehicle> getVehiclesByColor(String color) {
        ArrayList<Vehicle> colorFilteredVehicles = new ArrayList<>();
        for (Vehicle vehicle : inventory) {
            if (vehicle.getColor().equalsIgnoreCase(color)) {
                colorFilteredVehicles.add(vehicle);
            }
        }
        return colorFilteredVehicles;
    }

    public ArrayList<Vehicle> getVehiclesByMileage(int min, int max) {
        ArrayList<Vehicle> mileageFilteredVehicles = new ArrayList<>();
        for (Vehicle vehicle : inventory) {
            if (vehicle.getOdometer() >= min && vehicle.getOdometer() <= max) {
                mileageFilteredVehicles.add(vehicle);
            }
        }
        return mileageFilteredVehicles;
    }

    public ArrayList<Vehicle> getVehiclesByType(String type) {
        ArrayList<Vehicle> typeFilteredVehicles = new ArrayList<>();
        for (Vehicle vehicle : inventory) {
            if (vehicle.getVehicleType().equalsIgnoreCase(type)) {
                typeFilteredVehicles.add(vehicle);
            }
        }
        return typeFilteredVehicles;
    }

    public ArrayList<Vehicle> getAllVehicles() {
        return this.inventory;
    }

    public void addVehicle(Vehicle vehicle) {
        this.inventory.add(vehicle);
    }

    public void removeVehicle(Vehicle vehicle) {
        this.inventory.remove(vehicle);
    }

    //region getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    //endregion

}
