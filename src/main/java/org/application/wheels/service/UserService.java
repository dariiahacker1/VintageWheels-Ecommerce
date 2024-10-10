package org.application.wheels.service;

import org.application.wheels.dao.UserDao;
import org.application.wheels.models.User;

public class UserService extends AbstractService<User> {
    public UserService() { super(new UserDao()); }
}
