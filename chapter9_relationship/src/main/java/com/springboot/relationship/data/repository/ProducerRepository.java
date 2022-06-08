package com.springboot.relationship.data.repository;

import com.springboot.relationship.data.entity.Producer;
import org.springframework.data.jpa.repository.JpaRepository;

// 예제 9.21
public interface ProducerRepository extends JpaRepository<Producer, Long> {

}
