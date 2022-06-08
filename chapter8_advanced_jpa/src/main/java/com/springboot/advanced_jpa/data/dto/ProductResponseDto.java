package com.springboot.advanced_jpa.data.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProductResponseDto {

    private Long number;

    private String name;

    private int price;

    private int stock;

}
