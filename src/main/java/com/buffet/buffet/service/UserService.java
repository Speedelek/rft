package com.buffet.buffet.service;

import com.buffet.buffet.entities.registration.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserService{

    public void registerUser(User user);

    public User findByUsername(String username);

    public void deleteById(Long id);

    public void updateUser(User user);

    void userCheck(User user);


    //public String userActivation(String code);

}
