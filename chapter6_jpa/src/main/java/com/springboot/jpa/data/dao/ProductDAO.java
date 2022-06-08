package com.springboot.jpa.data.dao;

import com.springboot.jpa.data.entity.Product;

// 예제 6.9
public interface ProductDAO {

    Product insertProduct(Product product);

    Product selectProduct(Long number);

    Product updateProductName(Long number, String name) throws Exception;

    void deleteProduct(Long number) throws Exception;

}
