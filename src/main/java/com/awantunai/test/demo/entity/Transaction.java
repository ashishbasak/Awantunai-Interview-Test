package com.awantunai.test.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Transaction {
  private String bookCode;
  private String userCode;
}
