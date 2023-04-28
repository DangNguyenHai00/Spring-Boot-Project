package com.example.demo.controllers;

import com.example.demo.dtos.AddAuthorRequest;
import com.example.demo.models.Author;
import com.example.demo.services.AuthorService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@Api(value = "Author store")
public class AuthorController {
    private AuthorService authorService;
    public AuthorController(AuthorService authorService)
    {
        this.authorService = authorService;
    }

    @PostMapping(path="/author",consumes = "application/json")
    public Author AddNewAuthor(@RequestBody AddAuthorRequest authorRequest)
    {
        Author addAuthor = new Author();
        addAuthor.setAuthorName(authorRequest.getAuthorName());
        addAuthor.setBirthYear(authorRequest.getBirthYear());
        Author addedAuthor = authorService.AddNewAuthor(addAuthor);
        return addedAuthor;
    }
}
