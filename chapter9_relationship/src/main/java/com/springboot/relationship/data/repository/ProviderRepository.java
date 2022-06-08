package com.springboot.relationship.data.repository;

import com.springboot.relationship.data.entity.Provider;
import org.springframework.data.jpa.repository.JpaRepository;

// 예제 9.11
public interface ProviderRepository extends JpaRepository<Provider, Long> {

}
