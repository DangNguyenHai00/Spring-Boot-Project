package com.example.demo.dtos;

import lombok.Data;

import java.util.Date;

@Data
public class AddAuthorRequest {
    private String AuthorName;
    private Date BirthYear;
}
