package com.springboot.valid_exception.data.dto;

public class ChangeProductNameDto {

    private Long number;

    private String name;

    public ChangeProductNameDto(Long number, String name) {
        this.number = number;
        this.name = name;
    }

    public ChangeProductNameDto() {
    }

    public Long getNumber() {
        return this.number;
    }

    public String getName() {
        return this.name;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public void setName(String name) {
        this.name = name;
    }

}
