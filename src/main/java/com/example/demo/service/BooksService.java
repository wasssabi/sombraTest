package com.example.demo.service;

import com.example.demo.entity.BooksEntity;

import java.util.List;

public interface BooksService {

    BooksEntity getBook(Long id);
    void createBook(BooksEntity booksEntity);
    void deleteBook(Long id);
    void updateBook(BooksEntity booksEntity);
    List<BooksEntity> findAll();
    List<String> calcNumberOfBooksByGenre();
}
