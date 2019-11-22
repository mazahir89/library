package com.library.controller;

import com.library.entity.Book;
import com.library.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public Collection<Book> getBooks() {
        return bookService.getBooks();
    }

    @PostMapping
    public Book postBook(@RequestBody Book book) {

        return bookService.createBook(book);
    }

    @GetMapping(value = "/{id}")
    public Optional<Book> getBookById(@PathVariable("id") int id) {
        return bookService.getBooksById(id);
    }

    @DeleteMapping(value = "/{id}")
    public Optional<Book> deleteBookById(@PathVariable("id") int id) {
        return bookService.deleteBookById(id);
    }

 }
