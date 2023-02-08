package dev.vehicle.vehicle;

import dev.vehicle.vehicle.main.repository.VehicleRepositoryCustomImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
@EnableMongoRepositories
public class VehicleApplication {

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Bean
	public VehicleRepositoryCustomImpl vehicleRepositoryCustomImpl(MongoTemplate mongoTemplate) {
		return new VehicleRepositoryCustomImpl(mongoTemplate);
	}

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(VehicleApplication.class, args);

	}

}
