package com.example.smartphonne.controller;

import com.example.smartphonne.model.Products;
import com.example.smartphonne.service.ProductsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProductsController {

    @Autowired
    private ProductsService productsService;

    // Khởi tạo danh sách User
    public ProductsController() {
    }

    // Trả về danh sách User
    @GetMapping("/products")
    @ResponseBody
    public List<Products> getProductsList() {
        return productsService.findAll();
    }

    // Trả về một User cụ thể theo ID
    @GetMapping("/products/{item_id}")
    @ResponseBody
    public ResponseEntity<Products> getProductsById(@PathVariable("item_id") int productsItem_id) {
        for (Products products : productsService.findAll()) {
            if (products.getItem_id() == productsItem_id) {
                return ResponseEntity.status(200).body(products);
            }
        }
        return ResponseEntity.status(404).body(null); // Trả về lỗi 404 nếu không tìm thấy
    }

    // Xóa một User cụ thể theo ID
    @DeleteMapping("/products/{item_id}")
    @ResponseBody
    public ResponseEntity<List<Products>> removeProductsById(@PathVariable("item_id") Long productsItem_id) {
        productsService.delete(productsItem_id);
        return ResponseEntity.status(200).body(productsService.findAll()); // Trả về danh sách sau khi xóa
    }

    // Tạo một User mới
    @PostMapping("/products")
    @ResponseBody
    public ResponseEntity<Products> createProducts(@RequestBody Products products) {
        productsService.save(products);
        return ResponseEntity.status(201).body(products);
    }

    // Cập nhật thông tin một User cụ thể theo ID
    @PutMapping("/products/{item_id}")
    @ResponseBody
    public ResponseEntity<Products> updateProducts(@PathVariable("item_id") Long productsItem_id, @RequestBody Products updateProducts) {
        Products products = productsService.findById(productsItem_id);
        if (products != null) {
            products.setTitle(updateProducts.getTitle());
            products.setDescribe_p(updateProducts.getDescribe_p());
            products.setRelease_date(updateProducts.getRelease_date());
            productsService.save(products);
            return ResponseEntity.status(200).body(products);
        }
        return ResponseEntity.status(404).body(null);
    }
}
