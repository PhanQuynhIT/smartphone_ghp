package com.example.smartphonne.repository;
import com.example.smartphonne.model.Products;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductsRepository extends JpaRepository<Products, Long> {

}
