package com.example.simplecrud.controller;

import com.example.simplecrud.model.Book;
import com.example.simplecrud.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/books")
public class BookController {
    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    // Create a new book
    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        Book createdBook = bookService.createBook(book);
        return new ResponseEntity<>(createdBook, HttpStatus.CREATED);
    }

    // Get all books
    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> books = bookService.getAllBooks();
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    // Get a book by ID
//    @GetMapping("/{id}")
//    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
//        Book book = bookService.getBookById(id);
//        return new ResponseEntity<>(book, HttpStatus.OK);
//    }

    // Update a book by ID
//    @PutMapping("/{id}")
//    public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book bookDetails) {
//        Book updatedBook = bookService.updateBook(id, bookDetails);
//        return new ResponseEntity<>(updatedBook, HttpStatus.OK);
//    }

    // Delete a book by ID
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
//        bookService.deleteBook(id);
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }
}
