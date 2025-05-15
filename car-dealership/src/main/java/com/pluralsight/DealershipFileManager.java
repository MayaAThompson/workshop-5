package com.pluralsight;

import java.io.*;

public class DealershipFileManager {

    private final String INVENTORY_FILE = "./src/main/resources/inventory.csv";
    private String dealerInfo;

    public Dealership getDealership() {
        Dealership dealership = null;
        try {
            String input;
            Vehicle vehicle;

            BufferedReader reader = new BufferedReader(new FileReader(INVENTORY_FILE));
            dealerInfo = reader.readLine();
            String[] dealerInfoParts = dealerInfo.split("\\|");
            dealership = new Dealership(dealerInfoParts[0], dealerInfoParts[1], dealerInfoParts[2]);

            while ((input = reader.readLine()) != null) {
                String[] vehicleParameters = input.split("\\|");
                vehicle = new Vehicle(Integer.parseInt(vehicleParameters[0]), Integer.parseInt(vehicleParameters[1]), vehicleParameters[2], vehicleParameters[3], vehicleParameters[4], vehicleParameters[5], Integer.parseInt(vehicleParameters[6]), Double.parseDouble(vehicleParameters[7]));
                dealership.addVehicle(vehicle);
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found. " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Something happened while trying to read the file: " + e.getMessage());
        }
        return dealership;
    }

    public void saveDealership(Dealership dealership) {

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(INVENTORY_FILE));
            writer.write(dealerInfo);
            for (Vehicle vehicle : dealership.getAllVehicles()) {
                String formattedVehicle = String.format("\n%d|%d|%s|%s|%s|%s|%d|%.2f",vehicle.getVehicleIdNumber(), vehicle.getYear(), vehicle.getMake(), vehicle.getModel(), vehicle.getVehicleType(), vehicle.getColor(), vehicle.getOdometer(), vehicle.getPrice());
                writer.write(String.format(formattedVehicle));
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found. " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Something happened while trying to write the file: " + e.getMessage());
        }
    }
}
