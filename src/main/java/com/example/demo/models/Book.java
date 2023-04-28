package com.example.demo.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Table(name = "books")
@Data
public class Book {
    @Id
    @Column(name = "BookId",columnDefinition = "CHAR(36)")
    private String bookId;
    @Column(name = "Title")
    private String title;
    @Column(name = "Publisher")
    private String publisher;
    @Column(name = "AuthorId")
    private String authorId;
}
