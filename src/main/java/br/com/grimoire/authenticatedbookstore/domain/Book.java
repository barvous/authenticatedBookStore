package br.com.grimoire.authenticatedbookstore.domain;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Book {
    
    private String isbn;

    private String title;

    private String genre;

    private String summary;

    private Double price;

    private Author author;

    private String numberOfPages;

    private LocalDateTime publicationDate;

}
