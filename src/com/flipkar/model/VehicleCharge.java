package com.flipkar.model;

public class VehicleCharge {
    private VehicleRate rate;
    private VehicleType vehicleType;

    public VehicleCharge(VehicleRate rate, VehicleType vehicleType) {
        this.rate = rate;
        this.vehicleType = vehicleType;
    }

    @Override
    public String toString() {
        return "VehicleCharge{" +
                "rate=" + rate +
                ", vehicleType=" + vehicleType +
                '}';
    }

    public VehicleRate getRate() {
        return rate;
    }

    public void setRate(VehicleRate rate) {
        this.rate = rate;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }
}
