package com.project.library.service;

import com.project.library.domain.Book;
import com.project.library.domain.Comment;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class BookService {

//    Map<String, String> borrowBookMap = new HashMap<>();
    Map<Integer, Book> bookRepo = new HashMap<>();
    Map<Integer, List<Comment>> commentRepo = new HashMap<>();


    @PostConstruct
    public void init() {
        bookRepo.put(1, new Book(1, "The Great Gatsby", "F. Scott Fitzgerald", 180, "/src/images/book1.jpg", "Classics", false));
        bookRepo.put(2, new Book(2, "Pride and Prejudice", "Jane Austen", 320, "/src/images/book2.jpg", "Classics", true));
        bookRepo.put(3, new Book(3, "Crime and Punishment", "Fyodor Mihaylovic Dostoyevski", 687, "/src/images/book3.jpg", "Classics", true));
        bookRepo.put(4, new Book(4, "To Kill a Mockingbird", "Harper Lee", 360, "/src/images/book4.jpg", "Classics", true));
        bookRepo.put(5, new Book(5, "The Catcher in the Rye", "J. D. Salinger", 234, "/src/images/book5.jpg", "Classics", true));
        bookRepo.put(6, new Book(6, "1984", "George Orwell", 352, "/src/images/book6.jpg", "Classics", true));
        bookRepo.put(7, new Book(7, "Moby-Dick", "Herman Melville", 728, "/src/images/book7.jpg", "Classics", true));
        bookRepo.put(8, new Book(8, "War and Peace", "Leo Tolstoy", 1823, "/src/images/book8.jpg", "Classics", true));
        bookRepo.put(9, new Book(9, "Alice's Adventures in Wonderland", "Lewis Carroll", 128, "/src/images/book9.jpg", "Classics", true));
        bookRepo.put(10, new Book(10, "Jane Eyre", "Charlotte Bronte", 608, "/src/images/book10.jpg", "Classics", true));
        bookRepo.put(11, new Book(11, "Great Expectations", "Charles Dickens", 656, "/src/images/book11.jpg", "Classics", true));
        bookRepo.put(12, new Book(12, "The Adventures of Huckleberry Finn", "Mark Twain", 343, "/src/images/book12.jpg", "Classics", true));
        bookRepo.put(13, new Book(13, "Wuthering Heights", "Emily Bronte", 443, "/src/images/book13.jpg", "Classics", true));
        bookRepo.put(14, new Book(14, "The Picture of Dorian Gray", "Oscar Wilde", 280, "/src/images/book14.jpg", "Classics", true));
        bookRepo.put(15, new Book(15, "Don Quixote", "Miguel de Cervantes", 906, "/src/images/book15.jpg", "Classics", true));
        bookRepo.put(16, new Book(16, "Anna Karenina", "Leo Tolstoy", 1035, "/src/images/book16.jpg", "Classics", true));
        bookRepo.put(17, new Book(17, "Frankenstein", "Mary Shelley", 256, "/src/images/book17.jpg", "Classics", true));
        bookRepo.put(18, new Book(18, "The Brothers Karamazov", "Fyodor Dostoyevsky", 1080, "/src/images/book18.jpg", "Classics", true));
        bookRepo.put(19, new Book(19, "The Grapes of Wrath", "John Steinbeck", 540, "/src/images/book19.jpg", "Classics", true));
        bookRepo.put(20, new Book(20, "The Scarlet Letter", "Nathaniel Hawthorne", 264, "/src/images/book20.jpg", "Classics", true));
        bookRepo.put(21, new Book(21, "The Girl with the Dragon Tattoo", "Stieg Larsson", 646, "/src/images/book21.jpg", "Mystery", true));
        bookRepo.put(22, new Book(22, "Gone Girl", "Gillian Flynn", 600, "/src/images/book22.jpg", "Mystery", true));
        bookRepo.put(23, new Book(23, "The Hound of the Baskervilles", "Arthur Conan Doyle", 138, "/src/images/book23.jpg", "Mystery", true));
        bookRepo.put(24, new Book(24, "Big Little Lies", "Liane Moriarty", 416, "/src/images/book24.jpg", "Mystery", true));
        bookRepo.put(25, new Book(25, "The Da Vinci Code", "Dan Brown", 495, "/src/images/book25.jpg", "Mystery", true));
        bookRepo.put(26, new Book(26, "The Lord of the Rings", "J.R.R. Tolkien", 520, "/src/images/book26.jpg", "Fantasy", true));
        bookRepo.put(27, new Book(27, "Harry Potter and the Sorcerer's Stone", "J.K. Rowling", 300, "/src/images/book27.jpg", "Fantasy", true));
        bookRepo.put(28, new Book(28, "A Song of Ice and Fire", "George R.R. Martin", 847, "/src/images/book28.jpg", "Fantasy", true));
        bookRepo.put(29, new Book(29, "The Name of the Wind", "Patrick Rothfuss", 736, "/src/images/book29.jpg", "Fantasy", true));
        bookRepo.put(30, new Book(30, "Mistborn: The Final Empire", "Brandon Sanderson", 668, "/src/images/book30.jpg", "Fantasy", true));
        bookRepo.put(31, new Book(3, "Dune", "Frank Herbert", 712, "/src/images/book31.jpg", "Science Fiction", true));
        bookRepo.put(32, new Book(32, "Neuromancer", "William Gibson", 336, "/src/images/book32.jpg", "Science Fiction", true));
        bookRepo.put(33, new Book(33, "The Martian", "Andy Weir", 416, "/src/images/book33.jpg", "Science Fiction", true));
        bookRepo.put(34, new Book(34, "Foundation", "Isaac Asimov", 304, "/src/images/book34.jpg", "Science Fiction", true));
        bookRepo.put(35, new Book(35, "The Notebook", "Nicholas Sparks", 276, "/src/images/book35.jpg", "Romance", true));
        bookRepo.put(36, new Book(36, "Outlander", "Diana Gabaldon", 703, "/src/images/book36.jpg", "Romance", true));
        bookRepo.put(37, new Book(37, "Me Before You", "Jojo Moyes", 476, "/src/images/book37.jpg", "Romance", true));
        bookRepo.put(38, new Book(38, "The Fault in Our Stars", "John Green", 320, "/src/images/book38.jpg", "Romance", true));
        bookRepo.put(39, new Book(39, "The Silence of the Lambs", "Thomas Harris", 432, "/src/images/book39.jpg", "Mystery", true));
        bookRepo.put(40, new Book(40, "The Magician's Nephew (Narnia 1)", "C. S. Lewis", 240, " /src/images/book40.jpg", "Fantasy", true));
        bookRepo.put(41, new Book(41, "Brave New World", "Aldous Huxley", 288, "/src/images/book41.jpg", "Science Fiction", true));
        bookRepo.put(42, new Book(42, "Gone with the Wind", "Margaret Mitchell", 960, " /src/images/book42.jpg", "Romance", true));

    }

    public Set<Book> getBorrowedBooks() {
        return bookRepo.values().stream().filter(book -> !book.isAvailable())
                .collect(Collectors.toSet());
    }

    public void borrowBook(int bookId, String username) {
        Book book = bookRepo.get(bookId);
        book.setAvailable(false);
        book.setBorrowedBy(username);
    }

    public void returnBook(int bookId) {
        Book book = bookRepo.get(bookId);
        book.setAvailable(true);
        book.setBorrowedBy(null);
    }

    public Set<Book> getBorrowedBooks(String username) {

        return bookRepo.values()
                .stream()
                .filter(book -> book.getBorrowedBy().equals(username))
                .collect(Collectors.toSet());
    }

    public Set<Book> getBooks() {
        return new HashSet<>(bookRepo.values());
    }

    public void addComment(int bookId, Comment comment) {
        commentRepo.computeIfAbsent(bookId, (key) -> new ArrayList<>());
        commentRepo.get(bookId).add(comment);
    }

    public List<Comment> getComment(int bookId) {
        commentRepo.computeIfAbsent(bookId, (key) -> new ArrayList<>());
        List<Comment> comments = commentRepo.get(bookId);
        comments.sort(Comparator.comparing(Comment::getCreationDate));
        return comments;
    }


}
