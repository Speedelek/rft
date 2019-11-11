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

    public List<Product> getProductByKategoria(){
        return productRepository.findByKategoria(1);
    }
<<<<<<< HEAD
}
=======
}
>>>>>>> 14567ad1adfe984c01fc49cff1f729dd41384226
