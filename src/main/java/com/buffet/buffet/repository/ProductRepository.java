package com.buffet.buffet.repository;

import com.buffet.buffet.entities.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long> {

    List<Product> findAll();

    List<Product> findByKategoria(int kategoria);
}