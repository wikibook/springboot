package com.springboot.relationship.data.repository;

import com.springboot.relationship.data.entity.Product;
import com.springboot.relationship.data.entity.Provider;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProductRepositoryTest {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProviderRepository providerRepository;

    @Test
    public void relationshipTest1() {

        // 테스트 데이터 생성
        Provider provider = new Provider();
        provider.setName("ㅇㅇ물산");

        providerRepository.save(provider);

        System.out.println("checkpoint 1");

        Product product = new Product();
        product.setName("가위");
        product.setPrice(5000);
        product.setStock(500);
        product.setProvider(provider);

        productRepository.save(product);

        System.out.println("checkpoint 2");

        // 테스트
        System.out.println(
            "product : " + productRepository.findById(1L).orElseThrow(RuntimeException::new));

        System.out.println("checkpoint 3");

        System.out.println(
            "provider : " + productRepository.findById(1L).orElseThrow(RuntimeException::new)
                .getProvider());

    }

}