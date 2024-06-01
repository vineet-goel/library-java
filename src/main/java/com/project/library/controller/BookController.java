package com.project.library.controller;

import com.project.library.domain.Book;
import com.project.library.domain.Comment;
import com.project.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping
    public ResponseEntity<Void> borrowBook(@RequestBody Map<String, String> requestBody) {
        bookService.borrowBook(Integer.parseInt(requestBody.get("bookId")), requestBody.get("username"));
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/borrowed")
    public ResponseEntity<Set<Book>> getBorrowedBooks() {
        return ResponseEntity.ok(bookService.getBorrowedBooks());
    }

    @GetMapping()
    public ResponseEntity<Set<Book>> getBooks() {
        return ResponseEntity.ok(bookService.getBooks());
    }


    @PutMapping("{id}/return")
    public ResponseEntity<Void> returnBook(@PathVariable String id) {
        bookService.returnBook(Integer.parseInt(id));
        return ResponseEntity.noContent().build();
    }


    @PostMapping("{id}/comments")
    public ResponseEntity<Void> addComment(@PathVariable String id, @RequestBody Map<String, String> requestBody) {
        Comment comment = new Comment(requestBody.get("comment"), requestBody.get("username"));
        bookService.addComment(Integer.parseInt(id), comment);
        return ResponseEntity.noContent().build();
    }


    @GetMapping("{id}/comments")
    public ResponseEntity<List<Comment>> getComment(@PathVariable String id) {
        List<Comment> comment = bookService.getComment(Integer.parseInt(id));
        return ResponseEntity.ok(comment);
    }
}
