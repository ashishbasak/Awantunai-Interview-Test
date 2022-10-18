package com.awantunai.test.demo.repo.model.userStudent;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentUserRepo extends JpaRepository<StudentUser, Long> {
    Optional<StudentUser> findByUsernameAndPassword(String username, String password);
}
