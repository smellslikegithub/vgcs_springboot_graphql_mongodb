package dev.vehicle.vehicle.main.model;

public class VehicleInfo {
    private String msidn;
    private String engineStatus;
    private String fleet;
    private String brand;
    private String countryOfOperation;
    private String chassisNumber;
    private String cassisSeries;

    public VehicleInfo() {

    }

    public VehicleInfo(String msidn, String engineStatus, String fleet, String brand, String countryOfOperation, String chassisNumber, String cassisSeries) {
        this.msidn = msidn;
        this.engineStatus = engineStatus;
        this.fleet = fleet;
        this.brand = brand;
        this.countryOfOperation = countryOfOperation;
        this.chassisNumber = chassisNumber;
        this.cassisSeries = cassisSeries;
    }

    @Override
    public String toString() {
        return "VehicleInfo{" +
                "msidn='" + msidn + '\'' +
                ", engineStatus='" + engineStatus + '\'' +
                ", fleet='" + fleet + '\'' +
                ", brand='" + brand + '\'' +
                ", countryOfOperation='" + countryOfOperation + '\'' +
                ", chassisNumber='" + chassisNumber + '\'' +
                ", cassisSeries='" + cassisSeries + '\'' +
                '}';
    }

    public String getMsidn() {
        return msidn;
    }

    public void setMsidn(String msidn) {
        this.msidn = msidn;
    }

    public String getEngineStatus() {
        return engineStatus;
    }

    public void setEngineStatus(String engineStatus) {
        this.engineStatus = engineStatus;
    }

    public String getFleet() {
        return fleet;
    }

    public void setFleet(String fleet) {
        this.fleet = fleet;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCountryOfOperation() {
        return countryOfOperation;
    }

    public void setCountryOfOperation(String countryOfOperation) {
        this.countryOfOperation = countryOfOperation;
    }

    public String getChassisNumber() {
        return chassisNumber;
    }

    public void setChassisNumber(String chassisNumber) {
        this.chassisNumber = chassisNumber;
    }

    public String getCassisSeries() {
        return cassisSeries;
    }

    public void setCassisSeries(String cassisSeries) {
        this.cassisSeries = cassisSeries;
    }
}
