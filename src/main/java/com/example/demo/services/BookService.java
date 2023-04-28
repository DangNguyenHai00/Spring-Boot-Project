package com.example.demo.services;

import com.example.demo.models.Book;
import com.example.demo.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BookService {
    private BookRepository bookRepository;
    @Autowired
    public BookService(BookRepository bookRepository)
    {
        this.bookRepository=bookRepository;
    }
    public List<Book> GetAllBooks()
    {
        List<Book> books = bookRepository.findAll();
        return books;
    }

    public Book GetBookById(UUID id)
    {
        Optional<Book> optBook = bookRepository.findById(id);
        if(optBook.isPresent())
        {
            return optBook.get();
        }
        return null;
    }

    public Book AddNewBook(Book book)
    {
        Book addedBook = bookRepository.save(book);
        return addedBook;
    }

    public boolean DeleteBook(UUID id)
    {
        try {
            bookRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e)
        {
            return false;
        }
        return true;
    }
}
