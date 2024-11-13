package br.com.grimoire.authenticatedbookstore.application;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.grimoire.authenticatedbookstore.domain.Book;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {
    
    @PreAuthorize("hasRole('NORMAL_USER')")
    @GetMapping
    public ResponseEntity<List<Book>> findAllBooks(){
        
        List<Book> bookList = new ArrayList<>();

        return ResponseEntity.ok().body(bookList);

    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<String> createABook(){
        
        System.out.println("Creating a book");

        return ResponseEntity.ok().body("Book created");

    }
}
