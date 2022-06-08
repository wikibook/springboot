package com.springboot.api.dto;

// 예제 5.8
public class MemberDto {

    private String name;
    private String email;
    private String organization;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    @Override
    public String toString() {
        return "MemberDTO{" +
            "name='" + name + '\'' +
            ", email='" + email + '\'' +
            ", organization='" + organization + '\'' +
            '}';
    }

}
