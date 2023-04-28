package com.example.demo.controllers;

import com.example.demo.dtos.AddBookRequest;
import com.example.demo.models.Book;
import com.example.demo.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class BookController {
    private BookService bookService;

    @Autowired
    public BookController(BookService bookService)
    {
        this.bookService = bookService;
    }
    @GetMapping("/books")
    public List<Book> GetAllBooks()
    {
        List<Book> books = bookService.GetAllBooks();
        return books;
    }

    @GetMapping("/book/{id}")
    public ResponseEntity<Book> GetBookById(UUID id)
    {
        Optional<Book> optBook = Optional.ofNullable(bookService.GetBookById(id));
        if(optBook.isPresent())
        {
            return new ResponseEntity<>(optBook.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }

    @PostMapping(path="/book",consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Book AddNewBook(@RequestBody AddBookRequest req)
    {
        Book addBook = new Book();
        addBook.setTitle(req.getTitle());
        addBook.setAuthorId(req.getAuthorId());
        addBook.setPublisher(req.getPublisher());
        Book addedBook = bookService.AddNewBook(addBook);
        return addedBook;
    }

    @DeleteMapping("/{bookId}")
    @ResponseStatus(code=HttpStatus.NO_CONTENT)
    public Object deleteOrder(@PathVariable("bookId") UUID bookId)
    {
        boolean rs = bookService.DeleteBook(bookId);
        if(rs)
        {
            return new Object()
            {
                String Message = "Item has been deleted.";
            };
        }
        return new Object()
        {
            String Message = "Item does not exist.";
        };
    }
}
