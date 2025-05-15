package com.pluralsight;

import com.pluralsight.utils.IOUtils;

import java.util.ArrayList;

public class UserInterface {

    Dealership dealership;

    public UserInterface() {

    }

    public void display() {
        this.init();
        boolean keepRunning = true;
        while (keepRunning) {
            System.out.println(menuString());
            int choice = Integer.parseInt(IOUtils.messageAndResponse("Make your choice: "));

            switch (choice) {
                case 1-> this.processGetAllVehiclesRequest();
                case 2 -> this.processGetByPriceRequest();
                case 3 -> this.processGetByMakeModelRequest();
                case 4 -> this.processGetByYearRequest();
                case 5 -> this.processGetByColorRequest();
                case 6 -> this.processGetByMileageRequest();
                case 7 -> this.processGetByVehicleTypeRequest();
                case 8 -> this.processAddVehicleRequest();
                case 9 -> this.processRemoveVehicleRequest();
                case 0 -> keepRunning = false;
                default -> System.out.println("Please select one of the available options.");
            }
        }
        save();
    }

    public void processGetByPriceRequest() {
        double minFilter = 0;
        double maxFilter = 9999999;

        String minFilterString = IOUtils.messageAndResponse("Minimum price: ");
        minFilter = tryParseDouble(minFilterString, minFilter);

        String maxFilterString = IOUtils.messageAndResponse("Maximum price: ");
        maxFilter = tryParseDouble(maxFilterString, maxFilter);

        ArrayList<Vehicle> priceFilteredVehicles = dealership.getVehiclesByPrice(minFilter, maxFilter);
        if (priceFilteredVehicles.isEmpty()) {
            System.out.println("No vehicles found. Try expanding your search to find one of our great deals!");
        }
        else {
            for (Vehicle vehicle : priceFilteredVehicles) {
                System.out.println(vehicle.toConsoleOutString() + "\n");
            }
        }
    }

    public void processGetByMakeModelRequest() {
        String makeFilter = IOUtils.messageAndResponse("Make: ");
        String modelFilter = IOUtils.messageAndResponse("Model: ");

        ArrayList<Vehicle> makeModelFilteredVehicles = dealership.getVehiclesByMakeModel(makeFilter, modelFilter);
        if (makeModelFilteredVehicles.isEmpty()) {
            System.out.println("No vehicles found. Try expanding your search to find one of our great deals!");
        }
        else {
            for (Vehicle vehicle : makeModelFilteredVehicles) {
                System.out.println(vehicle.toConsoleOutString() + "\n");
            }
        }
    }

    public void processGetByYearRequest() {
        int minFilter = 0;
        int maxFilter = 9999999;

        String minFilterString = IOUtils.messageAndResponse("Minimum year: ");
        minFilter = tryParseInt(minFilterString, minFilter);

        String maxFilterString = IOUtils.messageAndResponse("Maximum year: ");
        maxFilter = tryParseInt(maxFilterString, maxFilter);

        ArrayList<Vehicle> yearFilteredVehicles = dealership.getVehiclesByYear(minFilter, maxFilter);
        if (yearFilteredVehicles.isEmpty()) {
            System.out.println("No vehicles found. Try expanding your search to find one of our great deals!");
        }
        else {
            for (Vehicle vehicle : yearFilteredVehicles) {
                System.out.println(vehicle.toConsoleOutString() + "\n");
            }
        }
    }

    public void processGetByColorRequest() {
        String colorFilter = IOUtils.messageAndResponse("Color: ");

        ArrayList<Vehicle> colorFilteredVehicles = dealership.getVehiclesByColor(colorFilter);

        if (colorFilteredVehicles.isEmpty()) {
            System.out.println("No vehicles found. Try expanding your search to find one of our great deals!");
        }
        else {
            for (Vehicle vehicle : colorFilteredVehicles) {
                System.out.println(vehicle.toConsoleOutString());
            }
        }
    }

    public void processGetByMileageRequest() {
        int minFilter = 0;
        int maxFilter = 9999999;

        String minFilterString = IOUtils.messageAndResponse("Minimum mileage: ");
        minFilter = tryParseInt(minFilterString, minFilter);

        String maxFilterString = IOUtils.messageAndResponse("Maximum mileage: ");
        maxFilter = tryParseInt(maxFilterString, maxFilter);

        ArrayList<Vehicle> mileageFilteredVehicles = dealership.getVehiclesByMileage(minFilter, maxFilter);
        if (mileageFilteredVehicles.isEmpty()) {
            System.out.println("No vehicles found. Try expanding your search to find one of our great deals!");
        }
        else {
            for (Vehicle vehicle : mileageFilteredVehicles) {
                System.out.println(vehicle.toConsoleOutString() + "\n");
            }
        }
    }

    public void processGetByVehicleTypeRequest() {
        String typeFilter = IOUtils.messageAndResponse("Vehicle Type: ");

        ArrayList<Vehicle> colorFilteredVehicles = dealership.getVehiclesByType(typeFilter);

        if (colorFilteredVehicles.isEmpty()) {
            System.out.println("No vehicles found. Try expanding your search to find one of our great deals!");
        }
        else {
            for (Vehicle vehicle : colorFilteredVehicles) {
                System.out.println(vehicle.toConsoleOutString());
            }
        }
    }

    public void processGetAllVehiclesRequest() {
        ArrayList<Vehicle> allVehicles = dealership.getAllVehicles();
        for (Vehicle vehicle : allVehicles) {
            System.out.println(vehicle.toConsoleOutString());
        }
    }

    public void processAddVehicleRequest() {
        int vehicleId = IOUtils.messageAndResponseInt("Vehicle ID Number: ");
        int year = IOUtils.messageAndResponseInt("Vehicle year: ");
        String make = IOUtils.messageAndResponse("Vehicle make: ");
        String model = IOUtils.messageAndResponse("Vehicle model: ");
        String type = IOUtils.messageAndResponse("Vehicle type: ");
        String color = IOUtils.messageAndResponse("Vehicle color: ");
        int odometer = IOUtils.messageAndResponseInt("Vehicle odometer reading: ");
        double price = IOUtils.messageAndResponseDouble("Vehicle price: $");

        Vehicle vehicle = new Vehicle(vehicleId, year, make, model, type, color, odometer, price);
        dealership.addVehicle(vehicle);
    }

    public void processRemoveVehicleRequest() {

    }

    private void init() {
        DealershipFileManager initDealer = new DealershipFileManager();
        this.dealership = initDealer.getDealership();
    }

    private void save() {
        DealershipFileManager saveDealer = new DealershipFileManager();
        saveDealer.saveDealership(dealership);
    }

    private String menuString() {
        return String.format("""
                Welcome to %s!
                What would you like to do?
                1) View all vehicles
                2) Sort vehicles by price
                3) Sort vehicles by make and model
                3) Sort vehicles by make and model
                4) Sort vehicles by year
                5) Sort vehicles by color
                6) Sort vehicles by mileage
                7) Sort vehicles by type
                8) Add a new vehicle
                9) Remove a vehicle
                10) Sell/Lease a vehicle
                0) Exit""", this.dealership.getName());
    }

    private static double tryParseDouble(String filterString, double filterDouble) {
        if (filterString != null) {
            try {
                filterDouble = Double.parseDouble(filterString);
            } catch (NumberFormatException e) {
                System.out.println("Error: you must enter a number. " + e.getMessage());
            }
        }
        return filterDouble;
    }

    private static int tryParseInt(String filterString, int filterInt) {
        if (filterString != null) {
            try {
                filterInt = Integer.parseInt(filterString);
            } catch (NumberFormatException e) {
                System.out.println("Error: you must enter a number. " + e.getMessage());
            }
        }
        return filterInt;
    }
}
