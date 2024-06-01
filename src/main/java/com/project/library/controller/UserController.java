package com.project.library.controller;

import com.project.library.domain.Book;
import com.project.library.domain.User;
import com.project.library.service.BookService;
import com.project.library.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Set;

@CrossOrigin
@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private BookService bookService;

    @PostMapping
    public ResponseEntity<Void> createUser(@RequestBody User user) {
        userService.save(user);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<User> getUser(@RequestParam String username, @RequestParam String password) {

        User user = userService.findUser(username, password);
        return Optional.ofNullable(user)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());

    }

    @GetMapping("/{username}/books-borrowed")
    public ResponseEntity<Set<Book>> getBorrowedBooks(@PathVariable String username) {
        return ResponseEntity.ok(bookService.getBorrowedBooks(username));

    }
}
