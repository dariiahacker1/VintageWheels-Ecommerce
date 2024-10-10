package org.application;

import jakarta.jws.soap.SOAPBinding;
import org.application.wheels.models.Car;
import org.application.wheels.models.Location;
import org.application.wheels.service.CarService;
import org.application.wheels.service.LocationService;
import org.application.wheels.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.application.wheels.models.User;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class VintageWheelsEcommerceApplication {

    public static void main(String[] args) {
        Car car = new Car("1", "mercedes", "1");

        Car new_car = new Car("2", "vintage", "2");

        new_car.setPrice(90);

        new_car.setDescription("descr");

        car.setDescription("descr");

        car.setPrice(78);

        car.setLocationId("1");

        List<Car> cars = new ArrayList<>();

        cars.add(car);

        Location location = new Location("1", "LA", "1");

        location.setLocationCars(cars);

        location.setLocationName("Los Angeles");

        List<Location> locations = new ArrayList<>();

        locations.add(location);

        cars.add(new_car);

        User user =  new User("1", "passwd", "egordem");

        user.setUserLocations(locations);

        LocationService locationService =  new LocationService();

        locationService.deleteAllEntities();

        locationService.closeConnection();

        //SpringApplication.run(VintageWheelsEcommerceApplication.class, args);
    }

}
