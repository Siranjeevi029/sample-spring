package com.demo2.demo2.repository;

import com.demo2.demo2.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
    // You can define custom queries here if needed.
}
