package com.springboot.relationship.data.repository.support;


import com.springboot.relationship.data.entity.Product;
import com.springboot.relationship.data.entity.QProduct;
import java.util.List;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

public class ProductRepositoryImpl extends QuerydslRepositorySupport implements
    ProductRepositoryCustom {

    public ProductRepositoryImpl() {
        super(Product.class);
    }

    @Override
    public List<Product> findByName(String name) {
        QProduct product = QProduct.product;

        List<Product> productList = from(product)
            .where(product.name.eq(name))
            .select(product)
            .fetch();

        return productList;
    }
}

// Reference (https://docs.spring.io/spring-data/jpa/docs/current/api/org/springframework/data/jpa/repository/support/QuerydslRepositorySupport.html)