package dev.vehicle.vehicle.main.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;


/**
 * Vehicle class
 *
 * @author
 * @version 1.0
 * @since 2021-03-01
 * "msidn" : "+467866547",
 * "engineStatus" : "OK",
 * "fleet" : "Thor's Fleet",
 * "brand" : "Volvo Construction Equipment",
 * "countryOfOperation": "Japan",
 * "chassisNumber" : "000643",
 * "cassisSeries": "VCE"
 */
@Data
@Document(collection = "vehicles")
public class Vehicle {
    @Id
    private String id;

    @TextIndexed
    private VehicleService vehicleService;
    @TextIndexed
    private VehicleInfo vehicleInfo;

    public Vehicle() {

    }

    public Vehicle(String id, VehicleService vehicleService, VehicleInfo vehicleInfo) {
        this.id = id;
        this.vehicleService = vehicleService;
        this.vehicleInfo = vehicleInfo;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id='" + id + '\'' +
                ", vehicleService=" + vehicleService +
                ", vehicleInfo=" + vehicleInfo +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public VehicleService getVehicleService() {
        return vehicleService;
    }

    public void setVehicleService(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    public VehicleInfo getVehicleInfo() {
        return vehicleInfo;
    }

    public void setVehicleInfo(VehicleInfo vehicleInfo) {
        this.vehicleInfo = vehicleInfo;
    }
}
