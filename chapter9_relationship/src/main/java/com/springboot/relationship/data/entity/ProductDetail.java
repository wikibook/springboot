package com.springboot.relationship.data.entity;

import lombok.*;

import javax.persistence.*;

// 예제 9.1
@Entity
@Table(name = "product_detail")
@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class ProductDetail extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    @OneToOne //(optional=false) 예제 9.5
    @JoinColumn(name = "product_number")
    private Product product;

}
