package com.awantunai.test.demo.entity;

import lombok.Data;

@Data
public class LibraryBook {
  private String bookCode;
  private String name;
  private String publisher;
  private Integer price;
  boolean available;
}
