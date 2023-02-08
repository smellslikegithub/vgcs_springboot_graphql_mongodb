package dev.vehicle.vehicle.main.model;

import java.util.List;

public class ListResponse{


    private List<VehicleResponse> vehicles;

    public ListResponse() {

    }
    public ListResponse(List<VehicleResponse> vehicles) {
        this.vehicles = vehicles;
    }

    public List<VehicleResponse> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<VehicleResponse> vehicles) {
        this.vehicles = vehicles;
    }
}