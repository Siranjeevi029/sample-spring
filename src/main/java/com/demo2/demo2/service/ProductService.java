package com.demo2.demo2.service;

import com.demo2.demo2.entity.ProductEntity;
import com.demo2.demo2.repository.ProductRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository repository;

    @Autowired
    public ProductService(ProductRepository repository) {
        this.repository = repository;
//         Optionally, initialize some sample data if the database is empty.
//        if(repository.count() == 0) {
//            repository.save(new ProductEntity("cinthol", "$20", "../first/photos/cinthol.jpg"));
//            repository.save(new ProductEntity("hamam", "$30", "../first/photos/hamam.jpg"));
//            repository.save(new ProductEntity("dettol", "$100", "../first/photos/dettol.jpg"));
//        }
    }

    public List<ProductEntity> getAllProducts() {
        return repository.findAll();
    }
    public ProductEntity createProduct(ProductEntity pe){
        return repository.save(pe);
    }
    public void deleteProduct(Long id){
         repository.deleteById(id);
    }

    public ProductEntity updateProduct(ProductEntity product,Long id) {
        Optional<ProductEntity> p=repository.findById(id);
        ProductEntity pp;
        if(p.isPresent())pp=p.get();
        else return null;
        BeanUtils.copyProperties(product, pp, "id");
        return repository.save(pp);
    }
    // You can add more service methods as needed.
}
