package com.library.DAO;

import com.library.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Optional;

@Component
public class BookDAO {

    @Autowired
    private BookRepository bookRepository;

    public Collection<Book> getBooks() {
        return  bookRepository.findAll();
    }

    public Book createBook(Book book) {
        return bookRepository.insert(book);
    }

    public Optional<Book> getBookById(int id) {
        return bookRepository.findById(id);
    }

    public Optional<Book> deleteBookById(int id) {
        Optional<Book> book = bookRepository.findById(id);
        book.ifPresent(b -> bookRepository.delete(b));
        return book;
    }
}
