package com.buffet.buffet.service;

import com.buffet.buffet.entities.registration.User;

public interface UserService {

    public void registerUser(User user);

    public User findByEmail(String email);

    //public String userActivation(String code);

}
