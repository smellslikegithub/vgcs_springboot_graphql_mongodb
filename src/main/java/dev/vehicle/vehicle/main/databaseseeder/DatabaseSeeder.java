package dev.vehicle.vehicle.main.databaseseeder;

import dev.vehicle.vehicle.main.model.*;
import dev.vehicle.vehicle.main.service.VehicleDbService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
public class DatabaseSeeder {
    // TODO: Maybe better to have a service discovery system like eureka.
    @Value("${mock.vehicle.api.url}")
    public String mockApiUrl;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    VehicleDbService vehicleDbService;

    @GetMapping("/seed_vehicles")
    @ResponseBody
    public List<Vehicle> seedVehiclesFromApiToDb() {

        // Get all vehicles from mock api
        ListResponse allVehicles = restTemplate.getForObject(mockApiUrl + "/list", ListResponse.class);

        List<Vehicle> vehicles = new ArrayList<>();
        for (VehicleResponse vehicle : allVehicles.getVehicles()) {

            // Get vehicle info
            try {
                VehicleInfo vehicleInfo = restTemplate.getForObject(mockApiUrl + "/info/?id=" + vehicle.getId(), VehicleInfo.class);
                if (vehicleInfo != null) {
                    // Get vehicle service
                    // TODO: Make this async using WebClientBuilder, for now, just using RestTemplate
                    VehicleService vehicleService = restTemplate.getForObject(mockApiUrl + "/vehicles/?id=" + vehicle.getId(), VehicleService.class);


                    // Build the entire vehicle object for saving to an external database. For e.g., mongodb in this case.

                    vehicles.add(new Vehicle(vehicle.getId(), vehicleService, vehicleInfo));

                //vehicleInfos.add(vehicleInfo);


                }
            } catch (RuntimeException e) {
                log.error("Error getting vehicle info for vehicle: " + vehicle.getId() + e.getMessage());
            }

        }

        vehicleDbService.storeVehicles(vehicles);
        log.info("VEHICLES ADDED TO DB: " + vehicles.size());
        return vehicles;
    }

    public String seederResponse(List<Vehicle> vehicles){
        StringBuilder ids = new StringBuilder();
        vehicles.stream().forEach(vehicle -> ids.append(vehicle.getId()).append("\n"));
        return "Vehicles added to db: \n" + ids.toString();
    }
}