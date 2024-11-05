package br.com.grimoire.authenticatedbookstore.domain;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Author {

    private String name;

    List<Book> bookList = new ArrayList<>();

    public Author(String name) {
        this.name = name;
    }

    public Author(String name, Book book) {
        this.name = name;
        bookList.add(book);
    }
}
