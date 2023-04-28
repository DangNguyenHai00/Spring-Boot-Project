package com.example.demo.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
@Entity
@Table(name="authors")
public class Author {
    @Id
    @Column(name = "AuthorId",columnDefinition = "CHAR(36)")
    private String AuthorId = UUID.randomUUID().toString();
    @Column(name = "AuthorName")
    private String AuthorName;
    @Column(name = "BirthYear")
    private Date BirthYear;
}
