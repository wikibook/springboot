package com.springboot.valid_exception.data.repository;


import com.springboot.valid_exception.data.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
