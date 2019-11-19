package com.buffet.buffet.service;

import com.buffet.buffet.entities.Product;
import com.buffet.buffet.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public List<Product> getProduct(){
        return productRepository.findAll();
    }

    public List<Product> getProductByKategoria(int category){
        return productRepository.findByKategoria(category);
    }
<<<<<<< HEAD
=======

    public List<Product> getProductByBuffetId(String buffetId) {return productRepository.findProductByBuffetId(buffetId);}
>>>>>>> 7e4fbc51e32d5afb7889d4b27656cd5f1a213188
}
