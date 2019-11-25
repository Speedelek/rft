package com.buffet.buffet.repository;


import com.buffet.buffet.entities.registration.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);

    User findByEmail(String email);

   // Long deleteByUsername(String username);

    User findByActivation(String code);

    void deleteByUsername(User user);
}