package com.flipkar.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.flipkar.excpetions.InvalidInputException;

public class Branch {
    private String name;
    private List<Vehicle> vehicles;

    public Branch() {
        vehicles = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void addVehicle(Vehicle vehicle) throws InvalidInputException {
        if (vehicle == null) {
            throw new InvalidInputException("null vehicle not allowed");
        }
        vehicles.add(vehicle);
    }

    public void addVehicle(List<Vehicle> vehicles) throws InvalidInputException {
        if (vehicles.isEmpty()) {
            throw new InvalidInputException("null vehicle not allowed");
        }
        this.vehicles.addAll(vehicles);
    }

    public void printBranchVehicles(Trip trip) {
        Car car;
        Map<String, VehicleCharge> vehicleChargeMap = new HashMap<>();
        for (Vehicle v : vehicles) {
            car = (Car) v;
            if (car.getTrip() == null || car.getTrip() != trip) {
                if (!vehicleChargeMap.containsKey(car.getVehicleType().name())) {
                    vehicleChargeMap.put(car.getVehicleType().name(), car.getVehicleCharge());
                }
            }
        }
        for (Map.Entry entry : vehicleChargeMap.entrySet()) {
            System.out.println("\"" + entry.getKey() + "\"" + "is available for VehicleCharge ->" + entry.getValue());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Branch branch = (Branch) o;

        return name != null ? name.equals(branch.name) : branch.name == null;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}
