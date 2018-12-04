package com.flipkar.service;

import java.util.List;

import com.flipkar.excpetions.InvalidInputException;
import com.flipkar.model.Branch;
import com.flipkar.model.Trip;
import com.flipkar.model.Vehicle;
import com.flipkar.model.VehicleType;
import com.flipkar.store.DatabaseStore;

public class VehicleRentalService {
    BranchManagerService branchManagerService = new BranchManagerService();

    public Vehicle rentVehicle(Trip trip, VehicleType vehicleType) throws InvalidInputException {
        List<Branch> branches = DatabaseStore.getAllBranches();
        if (branches.isEmpty()) {
            throw new InvalidInputException("No Booking allowed no branches");
        }

        Vehicle booked = null;
        for (Branch b : branches) {
            booked = branchManagerService.bookAvailableVehilceFromBranch(b, trip, vehicleType);
            break;
        }

        return booked;
    }

    public void ptintSytemView(Trip trip) throws InvalidInputException {
        List<Branch> branches = DatabaseStore.getAllBranches();
        for (Branch b : branches) {
            System.out.println(b.getName());
            b.printBranchVehicles(trip);
            System.out.println();
        }
    }
}
