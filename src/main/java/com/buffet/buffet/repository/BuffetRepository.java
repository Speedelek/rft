package com.buffet.buffet.repository;

import com.buffet.buffet.entities.BuffetEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BuffetRepository extends CrudRepository<BuffetEntity, Long> {

    //SELECT * FROM BUFFET
    List<BuffetEntity> findAll();

    BuffetEntity findByName(String name);

}
