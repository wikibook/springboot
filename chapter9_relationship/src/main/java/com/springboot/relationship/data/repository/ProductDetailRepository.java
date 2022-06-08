package com.springboot.relationship.data.repository;

import com.springboot.relationship.data.entity.ProductDetail;
import org.springframework.data.jpa.repository.JpaRepository;

// 예제 9.2
public interface ProductDetailRepository extends JpaRepository<ProductDetail, Long> {

}
