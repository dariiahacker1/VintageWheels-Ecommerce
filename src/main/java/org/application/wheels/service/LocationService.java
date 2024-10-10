package org.application.wheels.service;

import org.application.wheels.dao.LocationDao;
import org.application.wheels.models.Location;

public class LocationService extends AbstractService<Location> {
    public LocationService() { super(new LocationDao()); }
}
