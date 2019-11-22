package com.library.DAO;

import com.library.entity.Book;
import com.library.entity.BookUpdatePayload;
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

    public Optional<Book> updateBookById(int id, BookUpdatePayload bookUpdatePayload) {
        Optional<Book> book = bookRepository.findById(id);
        book.ifPresent(b -> b.setTitle(bookUpdatePayload.getTitle()));
        book.ifPresent(b -> b.setAuthor(bookUpdatePayload.getAuthor()));
        book.ifPresent(b -> b.setYear(bookUpdatePayload.getYear()));
        book.ifPresent(b -> b.setIsbn(bookUpdatePayload.getIsbn()));
        book.ifPresent(b -> bookRepository.save(b));

        return book;
    }
}
