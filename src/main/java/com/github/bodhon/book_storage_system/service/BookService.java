package com.github.bodhon.book_storage_system.service;

import com.github.bodhon.book_storage_system.model.Book;
import com.github.bodhon.book_storage_system.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    /**
     * Create a new product.
     * @param book the book to save
     * @return the saved book
     */
    public Book createBook(@Valid Book book) {
        return bookRepository.save(book);
    }

    /**
     * Update an existing product.
     * @param book the book with updated fields
     * @return the updated book
     */
    public Book updateBook(@Valid Book book) {
        return bookRepository.save(book);
    }

    /**
     * Find a product by its ID.
     * @param id the UUID of the book
     * @return an optional containing the book if found
     */
    public Optional<Book> getBook(UUID id) {
        return bookRepository.findById(id);
    }

    /**
     * List all books.
     * @return a list of all books
     */
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    /**
     * Delete a book by its ID.
     * @param id the UUID of the book to delete
     */
    public void deleteBook(UUID id) {
        bookRepository.deleteById(id);
    }

}
