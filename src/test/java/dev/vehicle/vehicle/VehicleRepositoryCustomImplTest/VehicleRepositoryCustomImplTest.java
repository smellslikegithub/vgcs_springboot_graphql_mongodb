package dev.vehicle.vehicle.VehicleRepositoryCustomImplTest;


import dev.vehicle.vehicle.main.model.Vehicle;
import dev.vehicle.vehicle.main.repository.VehicleRepositoryCustomImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import java.util.List;

@DataMongoTest
public class VehicleRepositoryCustomImplTest {

    // Provided the data is populated in the mongodb, then these tests serve as a quick way to test the custom queries
    // For the sake of testing live data, no mocks are used here. Actual calls are made to the database.

    @Autowired
    VehicleRepositoryCustomImpl vehicleRepositoryCustomImpl;

    @Test
    void getVehicleByPartialBrandTest() {
        List<Vehicle> result = vehicleRepositoryCustomImpl.getVehicleByPartialBrand("Truck");
        assert result.size() > 0;
    }

    @Test
    void getVehicleByServiceNameAndServiceStatusTest() {
        List<Vehicle> result = vehicleRepositoryCustomImpl.getVehicleByServiceNameAndServiceStatus("FuelMeasurment", "DEACTIVATED");
        System.out.println(result);
        assert result.size() == 1;

    }

}
