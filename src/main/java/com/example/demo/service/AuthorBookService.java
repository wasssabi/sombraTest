package com.example.demo.service;

import com.example.demo.entity.A_UDto;
import com.example.demo.entity.Auhor_BooksEntity;
import com.example.demo.entity.AuthorEntity;
import com.example.demo.entity.BooksEntity;

import java.util.List;

public interface AuthorBookService {

    Auhor_BooksEntity getAuhorBooksEntity(Long id);
    void create(A_UDto  a_uDto);
    void update(Auhor_BooksEntity auhor_booksEntity);
    void delete(Long id);

    List<Auhor_BooksEntity> getAll();

    List<AuthorEntity> authorWithMostBooks();

    List<BooksEntity> booksWithMoreThenOneAuthorWrittenBook();



}
