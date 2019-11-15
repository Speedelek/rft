package com.buffet.buffet.service;

import com.buffet.buffet.entities.registration.User;

public interface UserService {

    public void registerUser(User user);

    public User findByUsername(String username);



    //public String userActivation(String code);

}
