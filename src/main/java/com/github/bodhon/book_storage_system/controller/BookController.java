package com.github.bodhon.book_storage_system.controller;

import com.github.bodhon.book_storage_system.model.Book;
import com.github.bodhon.book_storage_system.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookService bookService;

    /**
     * Create a new product.
     * @param book the book to create
     * @return the created book
     */
    @PostMapping
    public ResponseEntity<Book> createBook(@Valid @RequestBody Book book) {
        return new ResponseEntity<>(bookService.createBook(book), HttpStatus.CREATED);
    }

    /**
     * Update an existing book.
     * @param id the UUID of the book
     * @param bookDetails the book to update
     * @return the updated book
     */
    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable UUID id, @Valid @RequestBody Book bookDetails) {
        Book book = bookService.getBook(id).orElseThrow();
        book.setName(bookDetails.getName());
        book.setSku(bookDetails.getSku());
        book.setDescription(bookDetails.getDescription());
        book.setGenre(bookDetails.getGenre());
//        book.setPrice(bookDetails.getPrice());
        book.setQuantity(bookDetails.getQuantity());
        book.setLastQuantityChange(bookDetails.getLastQuantityChange());
        book.setDateCreated(bookDetails.getDateCreated());

        final Book updatedProduct = bookService.createBook(book);
        return ResponseEntity.ok(updatedProduct);
    }

    /**
     * Get a book by its ID.
     * @param id the UUID of the book
     * @return the book if found
     */
    @GetMapping("/{id}")
    public ResponseEntity<Book> getBook(@PathVariable UUID id) {
        return bookService.getBook(id)
                .map(ResponseEntity::ok)
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * List all books.
     * @return the list of all books
     */
    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    /**
     * Delete a product by its ID.
     * @param id the UUID of the book
     * @return a response entity with HTTP status
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable UUID id) {
        bookService.deleteBook(id);
        return ResponseEntity.noContent().build();
    }

}
