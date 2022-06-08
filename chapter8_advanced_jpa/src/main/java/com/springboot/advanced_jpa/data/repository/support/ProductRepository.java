package com.springboot.advanced_jpa.data.repository.support;

import com.springboot.advanced_jpa.data.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// 예제 8.38
// repository 패키지 안에 있는 ProductRepository와 이름이 동일하여 Bean 생성 충돌이 발생하므로 Bean 이름을 지정해줘야함
@Repository("productRepositorySupport")
public interface ProductRepository extends JpaRepository<Product, Long>, ProductRepositoryCustom {

}
