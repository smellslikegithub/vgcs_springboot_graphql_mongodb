package dev.vehicle.vehicle.main.model;

public class VehicleResponse {

    public String name;
    public String id;

    public VehicleResponse() {

    }

    public VehicleResponse(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


}
