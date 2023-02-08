package dev.vehicle.vehicle.main.service;

import dev.vehicle.vehicle.main.model.Vehicle;
import dev.vehicle.vehicle.main.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleDbService {
    @Autowired
    private VehicleRepository vehicleRepository;

    public String storeVehicle(Vehicle vehicle) {
        vehicleRepository.save(vehicle);
        return "Vehicle stored";
    }

    public String storeVehicles(List<Vehicle> vehicles) {
        vehicleRepository.saveAll(vehicles);
        return "Vehicles of size " + vehicles.size() + " stored";
    }



}
