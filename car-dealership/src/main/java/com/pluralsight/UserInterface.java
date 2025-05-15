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

        ArrayList<Vehicle> yearFilteredVehicles = dealership.getVehiclesByPrice(minFilter, maxFilter);
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

    }

    public void processGetByMileageRequest() {

    }

    public void processGetByVehicleTypeRequest() {

    }

    public void processGetAllVehiclesRequest() {

    }

    public void processAddVehicleRequest() {

    }

    public void processRemoveVehicleRequest() {

    }

    private void init() {
        DealershipFileManager initDealer = new DealershipFileManager();
        this.dealership = initDealer.getDealership();
    }

    private String menuString() {
        return "Welcome to " + this.dealership.getName() + "!" +
                "\n\nWhat would you like to do?\n" +
                "\n1) View all vehicles" +
                "\n2) Sort vehicles by price" +
                "\n3) Sort by make and model" +
                "\n4) Sort by year" +
                "\n5) Sort by color" +
                "\n6) Sort by mileage" +
                "\n7) Sort by vehicle type" +
                "\n8) Add new vehicle" +
                "\n9) Remove a vehicle" +
                "\n0) Exit";

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
