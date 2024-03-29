package com.jobber.service;

import com.jobber.dto.RegistrationDto;
import com.jobber.entity.User;

public interface UserService extends GenericService<User, Long> {

    User getUserByLogin(String login);

    User getFullById(long id);

    void register(RegistrationDto dto);
}
