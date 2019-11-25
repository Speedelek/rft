package com.buffet.buffet.repository;

import com.buffet.buffet.entities.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long> {

    List<Product> findAll();

    List<Product> findByKategoria(int category);

    @Query(value = "select t.termek_id, t.nev, t.ar, t.kategoria_id" +
            " from termek t join bufe_termek bt on t.termek_id = bt.termek_id" +
            " join bufe b on bt.bufe_id = b.bufe_id" +
            " where b.bufe_id = :buffetId",
            nativeQuery = true)
    List<Product> findProductByBuffetId(@Param("buffetId") String buffetId);

    @Query(value = "select termek_id, nev, ar, kategoria_id from termek where termek_id = :productIdInt",
            nativeQuery = true)
    Product findById(@Param("productIdInt") Integer productIdInt);

    //Product findById(Integer productId);
}