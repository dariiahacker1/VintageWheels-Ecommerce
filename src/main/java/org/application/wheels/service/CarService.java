package org.application.wheels.service;

import org.application.wheels.dao.CarDao;
import org.application.wheels.models.Car;

public class CarService extends AbstractService<Car> {
    public CarService() { super(new CarDao()); }
}