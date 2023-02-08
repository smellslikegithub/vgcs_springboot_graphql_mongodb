package dev.vehicle.vehicle.main.model;

import org.springframework.data.mongodb.core.index.TextIndexed;

import java.util.ArrayList;

public class VehicleService {
    @TextIndexed
    private String communicationStatus;
    @TextIndexed
    private ArrayList<Service> services;

    public VehicleService() {

    }

    public VehicleService(String communicationStatus, ArrayList<Service> services) {
        this.communicationStatus = communicationStatus;
        this.services = services;
    }

    @Override
    public String toString() {
        return "VehicleService{" +
                "communicationStatus='" + communicationStatus + '\'' +
                ", services=" + services +
                '}';
    }

    public String getCommunicationStatus() {
        return communicationStatus;
    }

    public void setCommunicationStatus(String communicationStatus) {
        this.communicationStatus = communicationStatus;
    }

    public ArrayList<Service> getServices() {
        return services;
    }

    public void setServices(ArrayList<Service> services) {
        this.services = services;
    }


}
