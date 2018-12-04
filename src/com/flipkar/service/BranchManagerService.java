package com.flipkar.service;

import com.flipkar.excpetions.InvalidInputException;
import com.flipkar.model.Branch;
import com.flipkar.model.Car;
import com.flipkar.model.Trip;
import com.flipkar.model.Vehicle;
import com.flipkar.model.VehicleType;
import com.flipkar.store.DatabaseStore;

public class BranchManagerService {
    public void addBranch(Branch b) throws InvalidInputException {
        synchronized (this) {
            DatabaseStore.addBranch(b.getName(), b);
        }
    }

    public void getVehicles(Branch b) {

    }

    public Branch getBranch(String name) {
        return DatabaseStore.getBranch(name);
    }

    public Vehicle bookAvailableVehilceFromBranch(Branch b, Trip trip, VehicleType vehicleType) {
        synchronized (this) {
            for (Vehicle v : b.getVehicles()) {
                Car c = (Car) v;
                if (c.getVehicleType() == vehicleType && (c.getTrip() == null || c.getTrip() != trip)) {
                    c.setTrip(trip);
                    return c;
                }
            }
            return null;
        }
    }
}
