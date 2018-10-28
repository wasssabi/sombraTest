package com.example.demo.service;

import com.example.demo.entity.AuthorEntity;


import java.util.List;

public interface AuthorService {
    AuthorEntity getAuthor(Long id);

    void createAuthor(AuthorEntity authorEntity);

    void deleteAuthor(Long id);

    void updateAuthor(AuthorEntity authorEntity);

    List<AuthorEntity> getAuthors();

    List<AuthorEntity> findOlderThen55AndSortThem();
}
