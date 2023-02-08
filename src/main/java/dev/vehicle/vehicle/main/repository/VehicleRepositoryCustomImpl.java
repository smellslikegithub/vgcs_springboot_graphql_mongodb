package dev.vehicle.vehicle.main.repository;

import dev.vehicle.vehicle.main.model.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.data.mongodb.core.query.TextQuery;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class VehicleRepositoryCustomImpl {

    @Autowired
    private MongoTemplate mongoTemplate;

    public VehicleRepositoryCustomImpl() {

    }

    public VehicleRepositoryCustomImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public List<Vehicle> getVehicleByPartialBrand(String brandQuery) {
        try {
            TextQuery textQuery = TextQuery.queryText(new TextCriteria().matchingAny(brandQuery)).sortByScore();
            List<Vehicle> result = mongoTemplate.find(textQuery, Vehicle.class);
            return result;
        } catch (Exception e) {
            System.out.println(e);
        }

        return List.of();
    }

    public List<Vehicle> getVehicleByServiceNameAndServiceStatus(String serviceName, String serviceStatus) {
        try {
            TextQuery textQuery = TextQuery.queryText(new TextCriteria().matchingAny(serviceName)).sortByScore();
            List<Vehicle> result = mongoTemplate.find(textQuery, Vehicle.class)
                    .stream()
                    .filter(vehicle -> vehicle.getVehicleService()
                            .getServices()
                            .stream()
                            .anyMatch(service -> service.getStatus()
                                    .equals(serviceStatus)))
                    .toList();
            System.out.println(result);
            return result;
        } catch (Exception e) {
            System.out.println(e);
        }

        return List.of();
    }


}
