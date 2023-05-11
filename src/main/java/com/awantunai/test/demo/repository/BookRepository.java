package com.awantunai.test.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.awantunai.test.demo.entity.LibraryBook;

import java.util.Optional;

public interface BookRepository extends JpaRepository<LibraryBook, Long> {
  Optional<LibraryBook> findByName(String name);
}
