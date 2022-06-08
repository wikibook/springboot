package com.springboot.security.data.repository;


import com.springboot.security.data.entity.Product;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository extends JpaRepository<Product, Long> {

    /*
    아래 메소드는 책에서 소개하고 있는 Repository의 메소드 명명 규칙 예시입니다.
    */
    List<Product> findByNameLike(String name);

    List<Product> findByNameContaining(String name);

    List<Product> findByNameStartingWith(String name);

    List<Product> findByNameStartsWith(String name);

    List<Product> findByNameEndsWith(String name);

    List<Product> findByPriceGreaterThan(int price);

    List<Product> findByPriceLessThan(int price);

    List<Product> findByNameOrderByPriceAsc(String name);

}
