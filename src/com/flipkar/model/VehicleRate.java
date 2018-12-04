package com.flipkar.model;

public class VehicleRate {
    private int unit;
    private String currency;
    private TimeUnit timeUnit;

    public VehicleRate(int unit, String currency, TimeUnit timeUnit) {
        this.unit = unit;
        this.currency = currency;
        this.timeUnit = timeUnit;
    }

    @Override
    public String toString() {
        return "VehicleRate{" +
                "unit=" + unit +
                ", currency='" + currency + '\'' +
                ", timeUnit=" + timeUnit +
                '}';
    }

    public TimeUnit getTimeUnit() {
        return timeUnit;
    }

    public void setTimeUnit(TimeUnit timeUnit) {
        this.timeUnit = timeUnit;
    }

    public int getUnit() {
        return unit;
    }

    public void setUnit(int unit) {
        this.unit = unit;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
