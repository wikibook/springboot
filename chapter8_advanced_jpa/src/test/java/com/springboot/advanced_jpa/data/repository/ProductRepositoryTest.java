package com.springboot.advanced_jpa.data.repository;

import com.querydsl.core.Tuple;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.springboot.advanced_jpa.data.entity.Product;
import com.springboot.advanced_jpa.data.entity.QProduct;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
class ProductRepositoryTest {

    @Autowired
    ProductRepository productRepository;

    @Test
    void sortingAndPagingTest() {
        // given
        Product product1 = new Product();
        product1.setName("펜");
        product1.setPrice(1000);
        product1.setStock(100);
        product1.setCreatedAt(LocalDateTime.now());
        product1.setUpdatedAt(LocalDateTime.now());

        Product product2 = new Product();
        product2.setName("펜");
        product2.setPrice(5000);
        product2.setStock(300);
        product2.setCreatedAt(LocalDateTime.now());
        product2.setUpdatedAt(LocalDateTime.now());

        Product product3 = new Product();
        product3.setName("펜");
        product3.setPrice(500);
        product3.setStock(50);
        product3.setCreatedAt(LocalDateTime.now());
        product3.setUpdatedAt(LocalDateTime.now());

        Product savedProduct1 = productRepository.save(product1);
        Product savedProduct2 = productRepository.save(product2);
        Product savedProduct3 = productRepository.save(product3);

        System.out.println(productRepository.findByNameOrderByNumberAsc("펜"));
        System.out.println(productRepository.findByNameOrderByNumberDesc("펜"));

        System.out.println(productRepository.findByNameOrderByPriceAscStockDesc("펜"));

        // 예제 8.16
        System.out.println(productRepository.findByName("펜", Sort.by(Order.asc("price"))));
        System.out.println(productRepository.findByName("펜", Sort.by(Order.asc("price"), Order.desc("stock"))));
        // 예제 8.17
        System.out.println(productRepository.findByName("펜", getSort()));

        System.out.println(productRepository.findByName("펜", PageRequest.of(0, 2)));
        // 예제 8.19
        Page<Product> productPage = productRepository.findByName("펜", PageRequest.of(0, 2));
        // 예제 8.20
        System.out.println(productPage.getContent());

        System.out.println(productRepository.findByName("펜", PageRequest.of(0, 2, Sort.by(Order.asc("price")))));
        System.out.println(productRepository.findByName("펜", PageRequest.of(0, 2, Sort.by(Order.asc("price")))).getContent());
    }

    // 예제 8.17
    private Sort getSort() {
        return Sort.by(
                Order.asc("price"),
                Order.desc("stock")
        );
    }

    @Test
    public void queryAnnotationTest() {
        System.out.println(productRepository.findByName("펜"));
        System.out.println(productRepository.findByNameParam("펜"));

        List<Object[]> objects = productRepository.findByNameParam2("펜");
        for (Object[] object : objects) {
            System.out.println(object[0]);
            System.out.println(object[1]);
            System.out.println(object[2]);
        }
    }

    @Test
    public void findByNumberTest() {
        // given
        Product product = new Product();
        product.setName("펜");
        product.setPrice(1000);
        product.setStock(100);
        product.setCreatedAt(LocalDateTime.now());
        product.setUpdatedAt(LocalDateTime.now());

        Product savedProduct = productRepository.save(product);

        // when
        Product foundProduct = productRepository.findByNumber(savedProduct.getNumber())
                .orElseThrow(() -> new RuntimeException());

        // then
        Assertions.assertThat(savedProduct.getNumber()).isEqualTo(foundProduct.getNumber());
        Assertions.assertThat(savedProduct.getName()).isEqualTo(foundProduct.getName());
        Assertions.assertThat(savedProduct.getPrice()).isEqualTo(foundProduct.getPrice());
        Assertions.assertThat(savedProduct.getStock()).isEqualTo(foundProduct.getStock());

        // clean
        productRepository.delete(foundProduct);
    }

    @Test
    public void findAllByNameTest() {
        // given
        Product product1 = new Product();
        product1.setName("펜");
        product1.setPrice(1000);
        product1.setStock(100);
        product1.setCreatedAt(LocalDateTime.now());
        product1.setUpdatedAt(LocalDateTime.now());

        Product product2 = new Product();
        product2.setName("펜");
        product2.setPrice(2000);
        product2.setStock(200);
        product2.setCreatedAt(LocalDateTime.now());
        product2.setUpdatedAt(LocalDateTime.now());

        Product savedProduct = productRepository.save(product1);
        Product savedProduct2 = productRepository.save(product2);

        // when
        List<Product> foundProducts = productRepository.findAllByName("펜");
        Product foundProduct1 = foundProducts.get(0);
        Product foundProduct2 = foundProducts.get(1);

        // then
        Assertions.assertThat(foundProduct1.getNumber()).isEqualTo(savedProduct.getNumber());
        Assertions.assertThat(foundProduct1.getName()).isEqualTo(savedProduct.getName());
        Assertions.assertThat(foundProduct1.getPrice()).isEqualTo(savedProduct.getPrice());
        Assertions.assertThat(foundProduct1.getStock()).isEqualTo(savedProduct.getStock());

        Assertions.assertThat(foundProduct2.getNumber()).isEqualTo(savedProduct2.getNumber());
        Assertions.assertThat(foundProduct2.getName()).isEqualTo(savedProduct2.getName());
        Assertions.assertThat(foundProduct2.getPrice()).isEqualTo(savedProduct2.getPrice());
        Assertions.assertThat(foundProduct2.getStock()).isEqualTo(savedProduct2.getStock());

        // clean
        productRepository.delete(foundProduct1);
        productRepository.delete(foundProduct2);
    }

    @Test
    public void queryByNumberTest() {
        // given
        Product product = new Product();
        product.setName("펜");
        product.setPrice(1000);
        product.setStock(100);
        product.setCreatedAt(LocalDateTime.now());
        product.setUpdatedAt(LocalDateTime.now());

        Product savedProduct = productRepository.save(product);

        // when
        Product queriedProduct = productRepository.queryByNumber(savedProduct.getNumber());

        // then
        Assertions.assertThat(savedProduct.getNumber()).isEqualTo(queriedProduct.getNumber());
        Assertions.assertThat(savedProduct.getName()).isEqualTo(queriedProduct.getName());
        Assertions.assertThat(savedProduct.getPrice()).isEqualTo(queriedProduct.getPrice());
        Assertions.assertThat(savedProduct.getStock()).isEqualTo(queriedProduct.getStock());

        // clean
        productRepository.delete(queriedProduct);
    }

    @Test
    public void existsByNumberTest() {
        // given
        Product product = new Product();
        product.setName("펜");
        product.setPrice(1000);
        product.setStock(100);
        product.setCreatedAt(LocalDateTime.now());
        product.setUpdatedAt(LocalDateTime.now());

        Product savedProduct = productRepository.save(product);

        // when
        boolean isExisted = productRepository.existsByNumber(savedProduct.getNumber());

        // then
        Assertions.assertThat(isExisted).isTrue();
    }

    @Test
    public void countByNameTest() {
        // given
        Product product = new Product();
        product.setName("펜");
        product.setPrice(1000);
        product.setStock(100);
        product.setCreatedAt(LocalDateTime.now());
        product.setUpdatedAt(LocalDateTime.now());

        Product savedProduct = productRepository.save(product);

        // when
        Long count = productRepository.countByName("펜");

        // then
        Assertions.assertThat(count).isEqualTo(1);

        // clean
        Product foundProduct = productRepository.findByNumber(savedProduct.getNumber())
                .orElseThrow(() -> new RuntimeException());
        productRepository.delete(foundProduct);
    }

    // 이후 코드는 QueryDSL 관련 테스트입니다.
    @PersistenceContext
    EntityManager entityManager;

    // 예제 8.26
    @Test
    void queryDslTest() {
        JPAQuery<Product> query = new JPAQuery(entityManager);
        QProduct qProduct = QProduct.product;

        List<Product> productList = query
                .from(qProduct)
                .where(qProduct.name.eq("펜"))
                .orderBy(qProduct.price.asc())
                .fetch();

        for (Product product : productList) {
            System.out.println("----------------");
            System.out.println();
            System.out.println("Product Number : " + product.getNumber());
            System.out.println("Product Name : " + product.getName());
            System.out.println("Product Price : " + product.getPrice());
            System.out.println("Product Stock : " + product.getStock());
            System.out.println();
            System.out.println("----------------");
        }
    }

    // 예제 8.27
    @Test
    void queryDslTest2() {
        JPAQueryFactory jpaQueryFactory = new JPAQueryFactory(entityManager);
        QProduct qProduct = QProduct.product;

        List<Product> productList = jpaQueryFactory.selectFrom(qProduct)
                .where(qProduct.name.eq("펜"))
                .orderBy(qProduct.price.asc())
                .fetch();

        for (Product product : productList) {
            System.out.println("----------------");
            System.out.println();
            System.out.println("Product Number : " + product.getNumber());
            System.out.println("Product Name : " + product.getName());
            System.out.println("Product Price : " + product.getPrice());
            System.out.println("Product Stock : " + product.getStock());
            System.out.println();
            System.out.println("----------------");
        }
    }

    // 예제 8.28
    @Test
    void queryDslTest3() {
        JPAQueryFactory jpaQueryFactory = new JPAQueryFactory(entityManager);
        QProduct qProduct = QProduct.product;

        List<String> productList = jpaQueryFactory
                .select(qProduct.name)
                .from(qProduct)
                .where(qProduct.name.eq("펜"))
                .orderBy(qProduct.price.asc())
                .fetch();

        for (String product : productList) {
            System.out.println("----------------");
            System.out.println("Product Name : " + product);
            System.out.println("----------------");
        }

        List<Tuple> tupleList = jpaQueryFactory
                .select(qProduct.name, qProduct.price)
                .from(qProduct)
                .where(qProduct.name.eq("펜"))
                .orderBy(qProduct.price.asc())
                .fetch();

        for (Tuple product : tupleList) {
            System.out.println("----------------");
            System.out.println("Product Name : " + product.get(qProduct.name));
            System.out.println("Product Name : " + product.get(qProduct.price));
            System.out.println("----------------");
        }
    }

    @Test
    void queryDslTupleTest() {
        JPAQueryFactory jpaQueryFactory = new JPAQueryFactory(entityManager);
        QProduct qProduct = QProduct.product;

        List<Tuple> productList = jpaQueryFactory
                .select(qProduct.name, qProduct.price)
                .from(qProduct)
                .where(qProduct.name.eq("펜"))
                .orderBy(qProduct.price.asc())
                .fetch();

        for (Tuple product : productList) {
            System.out.println("----------------");
            System.out.println("Product Name : " + product.get(qProduct.name));
            System.out.println("Product Price : " + product.get(qProduct.price));
            System.out.println("----------------");
        }
    }

    // 예제 8.30
    /**
     * Bean 객체로 등록된 JPAQueryFactory를 활용
     */
    @Autowired
    JPAQueryFactory jpaQueryFactory;

    @Test
    void queryDslTest4() {
        QProduct qProduct = QProduct.product;

        List<String> productList = jpaQueryFactory
                .select(qProduct.name)
                .from(qProduct)
                .where(qProduct.name.eq("펜"))
                .orderBy(qProduct.price.asc())
                .fetch();

        for (String product : productList) {
            System.out.println("----------------");
            System.out.println("Product Name : " + product);
            System.out.println("----------------");
        }
    }

    // 예제 8.44
    @Test
    public void auditingTest(){
        Product product = new Product();
        product.setName("펜");
        product.setPrice(1000);
        product.setStock(100);

        Product savedProduct = productRepository.save(product);

        System.out.println("productName : " + savedProduct.getName());
        System.out.println("createdAt : " + savedProduct.getCreatedAt());
    }

}