package Controller;

import java.awt.print.Book;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Service.BookService;

@RestController
@RequestMapping("/api/books")
public class BookController {
    @Autowired
    private BookService bookService;
    
    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        return ResponseEntity.ok(bookService.findAll());
    }
    
    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        return ResponseEntity.ok(bookService.save(book));
    }
}

