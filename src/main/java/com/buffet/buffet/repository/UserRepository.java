package com.buffet.buffet.repository;


import com.buffet.buffet.entities.registration.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

    User findByEmail(String email);

    User findByActivation(String code);

}