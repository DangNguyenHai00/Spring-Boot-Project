package com.example.demo.dtos;

import lombok.Data;

import java.util.UUID;

@Data
public class AddBookRequest {
    private String title;
    private String publisher;
    private String authorId;
}
