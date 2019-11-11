package com.buffet.buffet.repository;

import com.buffet.buffet.entities.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long> {

    List<Product> findAll();

    List<Product> findByKategoria(int kategoria);
<<<<<<< HEAD
}
=======
}
>>>>>>> 14567ad1adfe984c01fc49cff1f729dd41384226
