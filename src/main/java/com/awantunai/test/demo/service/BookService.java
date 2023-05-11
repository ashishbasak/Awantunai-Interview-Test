package com.awantunai.test.demo.service;

import com.awantunai.test.demo.entity.LibraryBook;
import com.awantunai.test.demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
  private final BookRepository bookRepository;

  @Autowired
  public BookService(BookRepository bookRepository) {
    this.bookRepository = bookRepository;
  }

//  public LibraryBook findBookByName(String ) {
//
//  }
}
