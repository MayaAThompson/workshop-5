package com.pluralsight;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class DealershipTest {

    @Test
    void testGetAllVehicles() {
        Vehicle newVehicle = new Vehicle(1111, 2004, "Lexus", "IS300", "Sedan", "Silver", 210000, 9000.00);
        Dealership dealership = new Dealership("Maya's Performance Used Cars", "1234 Fake Way, Nowhere, TX 75757", "214-123-4567");
        dealership.addVehicle(newVehicle);

        ArrayList<Vehicle> actual = dealership.getAllVehicles();

        assertTrue(actual.contains(newVehicle));

    }
}