package com.flipkar.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.flipkar.excpetions.InvalidInputException;
import com.flipkar.model.Branch;
import com.flipkar.model.Car;
import com.flipkar.model.TimeUnit;
import com.flipkar.model.Trip;
import com.flipkar.model.Vehicle;
import com.flipkar.model.VehicleCharge;
import com.flipkar.model.VehicleRate;
import com.flipkar.model.VehicleStatus;
import com.flipkar.model.VehicleType;

import org.junit.Test;

public class FipkarServiceTest {

    private BranchManagerService branchManagerService = new BranchManagerService();
    private VehicleRentalService vehicleRentalService = new VehicleRentalService();

    @Test
    public void addBranch() throws Exception {
        addBranch("kormangla");
        System.out.println(" ");
        addBranch("jayanagr");
        System.out.println(" ");
        addBranch("malleshwaram");
        vehicleRentalService.ptintSytemView(null);
    }

    @Test
    public void rentVehicle() {
        try {
            addBranch("kormangla");
            System.out.println(" ");
            addBranch("jayanagr");
            System.out.println(" ");
            addBranch("malleshwaram");

            Trip trip = new Trip();
            Date startTime = new SimpleDateFormat("yyyy-MM-dd hh").parse("2011-01-01 11");
            Date endTime = new SimpleDateFormat("yyyy-MM-dd hh").parse("2011-01-01 12");
            trip.setStartTime(startTime);
            trip.setEndTime(endTime);
            vehicleRentalService.ptintSytemView(trip);
            vehicleRentalService.rentVehicle(trip, VehicleType.SUV);
            vehicleRentalService.ptintSytemView(trip);
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (InvalidInputException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void addBranch(String branchName) throws InvalidInputException {
        List<Vehicle> vehicles = new ArrayList<>();
        //For kormangla
        Branch b = new Branch();
        b.setName(branchName);
        Car v = new Car();
        v.setNamePlate("vehicle1");
        v.setVehicleType(VehicleType.SUV);
        v.setVehicleStatus(VehicleStatus.IDLE);
        VehicleRate vehicleRate = new VehicleRate(12, "INR", TimeUnit.HOUR);
        VehicleCharge vehicleCharge = new VehicleCharge(vehicleRate, VehicleType.SUV);
        v.setVehicleCharge(vehicleCharge);

        vehicles.add(v);

        for (int i = 0; i < 3; i++) {
            Car v1 = new Car();
            v1.setNamePlate("vehicle + " + i);
            v1.setVehicleType(VehicleType.SEDAN);
            v1.setVehicleStatus(VehicleStatus.IDLE);
            VehicleRate vehicleRate1 = new VehicleRate(10, "INR", TimeUnit.HOUR);
            VehicleCharge vehicleCharge1 = new VehicleCharge(vehicleRate, VehicleType.SEDAN);
            v1.setVehicleCharge(vehicleCharge);
            vehicles.add(v1);
        }

        b.addVehicle(vehicles);
        branchManagerService.addBranch(b);
    }
}