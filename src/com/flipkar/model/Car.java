package com.flipkar.model;

public class Car implements Vehicle {
    private VehicleType vehicleType;
    private String namePlate;
    private VehicleStatus vehicleStatus;
    private VehicleCharge vehicleCharge;
    private Trip trip;

    public Trip getTrip() {
        return trip;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Car car = (Car) o;

        if (vehicleType != car.vehicleType) {
            return false;
        }
        if (namePlate != null ? !namePlate.equals(car.namePlate) : car.namePlate != null) {
            return false;
        }
        return vehicleStatus == car.vehicleStatus;
    }

    @Override
    public int hashCode() {
        int result = vehicleType != null ? vehicleType.hashCode() : 0;
        result = 31 * result + (namePlate != null ? namePlate.hashCode() : 0);
        result = 31 * result + (vehicleStatus != null ? vehicleStatus.hashCode() : 0);
        return result;
    }

    public VehicleCharge getVehicleCharge() {
        return vehicleCharge;
    }

    public void setVehicleCharge(VehicleCharge vehicleCharge) {
        this.vehicleCharge = vehicleCharge;
    }

    public VehicleStatus getVehicleStatus() {
        return vehicleStatus;
    }

    public void setVehicleStatus(VehicleStatus vehicleStatus) {
        this.vehicleStatus = vehicleStatus;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getNamePlate() {
        return namePlate;
    }

    public void setNamePlate(String namePlate) {
        this.namePlate = namePlate;
    }
}
