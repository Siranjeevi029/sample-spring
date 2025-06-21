package com.demo2.demo2.module;

import com.demo2.demo2.service.ProductService;
import com.demo2.demo2.entity.ProductEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class ProductController {

    @Autowired
    private ProductService service;
    @GetMapping("/")
    public String message() {
        return "hello";
    }

    @GetMapping("/posts")
    public List<ProductEntity> getMessage() {
//        System.out.println(service.getAllProducts());
        return service.getAllProducts();
    }
    @PostMapping("/posts")
    public ProductEntity post(@RequestBody ProductEntity pe){
        return service.createProduct(pe);
    }
    @DeleteMapping("/posts/{id}")
    public void delete(@PathVariable Long id){
         service.deleteProduct(id);
    }
    @PutMapping("/posts/{id}")
    public ProductEntity update(@RequestBody ProductEntity product,@PathVariable Long id){
        return service.updateProduct(product,id);
    }
}
