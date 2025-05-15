package com.pluralsight;

public class Vehicle {
    private int vehicleIdNumber;
    private int year;
    private String make;
    private String model;
    private String vehicleType;
    private String color;
    private int odometer;
    private double price;

    public Vehicle(int vehicleIdNumber, int year, String make, String model, String vehicleType, String color, int odometer, double price) {
        this.vehicleIdNumber = vehicleIdNumber;
        this.year = year;
        this.make = make;
        this.model = model;
        this.vehicleType = vehicleType;
        this.color = color;
        this.odometer = odometer;
        this.price = price;
    }

    //region getters and setters
    public int getVehicleIdNumber() {
        return vehicleIdNumber;
    }

    public void setVehicleIdNumber(int vehicleIdNumber) {
        this.vehicleIdNumber = vehicleIdNumber;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getOdometer() {
        return odometer;
    }

    public void setOdometer(int odometer) {
        this.odometer = odometer;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    //endregion

    public String toFileString() {
        return String.format("%d|%d|%s|%s|%s|%s|%d|%.2f", this.vehicleIdNumber, this.year, this.make, this.model, this.vehicleType, this.color, this.odometer, this.price);
    }

    public String toConsoleOutString() {
        return String.format("""
                        Vehicle ID: %d
                        Year: %d
                        Make: %s
                        Model %s
                        Vehicle Type: %s
                        Color: %s
                        Odometer: %d
                        Price: $%.2f""",
                this.vehicleIdNumber, this.year, this.make, this.model, this.vehicleType, this.color, this.odometer, this.price);

    }
}
