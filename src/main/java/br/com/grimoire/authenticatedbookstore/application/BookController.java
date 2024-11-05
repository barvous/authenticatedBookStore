package br.com.grimoire.authenticatedbookstore.application;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.grimoire.authenticatedbookstore.domain.Book;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {
    
    @GetMapping
    public ResponseEntity<List<Book>> findAllBooks(){
        
        List<Book> bookList = new ArrayList<>();

        return ResponseEntity.ok().body(bookList);

    }
}
