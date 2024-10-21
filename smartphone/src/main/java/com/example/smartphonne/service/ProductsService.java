package com.example.smartphonne.service;

import com.example.smartphonne.model.Products;
import com.example.smartphonne.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsService {
    @Autowired
    private ProductsRepository productsRepository;

    public List<Products> findAll() {
        return productsRepository.findAll();
    }

    public Products findById(Long item_id) {
        return
                productsRepository.findById(item_id).orElseThrow(() -> new RuntimeException("Product not found"));
    }
    public Products save(Products products) {
        return productsRepository.save(products);
    }
    public Products update(Products products) {
        return productsRepository.save(products);
    }
    public void delete(Long item_id) {
        productsRepository.deleteById(item_id);
    }


}