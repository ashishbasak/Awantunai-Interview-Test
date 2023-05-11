package com.awantunai.test.demo.repository;

import com.awantunai.test.demo.entity.Airplane;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirplaneRepository extends JpaRepository<Airplane, Integer> {

}
