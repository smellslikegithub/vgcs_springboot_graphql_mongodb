package dev.vehicle.vehicle.main.repository;

import dev.vehicle.vehicle.main.model.Vehicle;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends MongoRepository<Vehicle, String> {

}
