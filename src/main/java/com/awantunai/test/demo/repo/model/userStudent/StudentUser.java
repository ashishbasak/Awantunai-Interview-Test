package com.awantunai.test.demo.repo.model.userStudent;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "student-user")
public class StudentUser {
    @Id
    @Column(name="userId")
    Long userid;
    @Column(name="username")
    String username;
    @Column(name="password")
    String password;
}
