package com.awantunai.test.demo.repository;

import com.awantunai.test.demo.entity.Pilot;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PilotRepository extends JpaRepository<Pilot, Integer> {

  // for login
  boolean existsByUsernameAndDeletedAtIsNull(String username);

  Optional<Pilot> findByIdAndDeletedAtIsNull(Integer id);
}
