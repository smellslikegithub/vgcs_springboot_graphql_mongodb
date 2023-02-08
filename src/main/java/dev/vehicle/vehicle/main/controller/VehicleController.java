package dev.vehicle.vehicle.main.controller;

import dev.vehicle.vehicle.main.model.Vehicle;
import dev.vehicle.vehicle.main.repository.VehicleRepository;
import dev.vehicle.vehicle.main.repository.VehicleRepositoryCustomImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class VehicleController {

    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private VehicleRepositoryCustomImpl vehicleRepositoryCustomImpl;


    @PostMapping("/add_vehicle")
    public String saveVehicle(Vehicle vehicle) {
        vehicleRepository.save(vehicle);

        return "Added vehicle with id: " + vehicle.getId();
    }

    @PostMapping("/add_vehicles")
    public String saveVehicle(List<Vehicle> vehicles) {
        vehicleRepository.saveAll(vehicles);
        return "Added " + vehicles.size() + " vehicles";
    }

    @GetMapping("/get_vehicles")
    public List<Vehicle> getVehicles() {
        return vehicleRepository.findAll();
    }

    @GetMapping("/get_vehicle/{id}")
    public Optional<Vehicle> getVehicle(@PathVariable String id) {
        return vehicleRepository.findById(id);
    }

    @DeleteMapping("/delete_vehicle/{id}")
    public String deleteVehicle(@PathVariable String id) {
        vehicleRepository.deleteById(id);
        return "Vehicle deleted with id: " + id;
    }

    @SchemaMapping(typeName = "Query", value = "vehicleById")
    public Optional<Vehicle> vehicleById(@Argument String id) {


        Optional<Vehicle> vehicle = Optional.ofNullable(vehicleRepository.findById(id).orElse(null));

        return vehicle;

    }

    @SchemaMapping(typeName = "Query", value = "vehiclesByBrand")
    public List<Vehicle> vehiclesByBrand(@Argument String brand) {
        // Allows partial matching for the brand which at the moment I am using as the vehicle name
        return vehicleRepositoryCustomImpl.getVehicleByPartialBrand(brand);
    }

    @SchemaMapping(typeName = "Query", value = "vehiclesByServiceStatus")
    public List<Vehicle> vehiclesByServiceNameAndStatus(@Argument String serviceName, @Argument String serviceStatus) {
        return vehicleRepositoryCustomImpl.getVehicleByServiceNameAndServiceStatus(serviceName, serviceStatus);
    }

}
