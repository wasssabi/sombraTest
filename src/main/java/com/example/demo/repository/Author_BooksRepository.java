package com.example.demo.repository;

import com.example.demo.entity.Auhor_BooksEntity;
import com.example.demo.entity.AuthorEntity;
import com.example.demo.entity.BooksEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Author_BooksRepository extends JpaRepository<Auhor_BooksEntity,Long> {
    @Query(value = "SELECT  b.book FROM Auhor_BooksEntity b where b.author=?1")
    List<BooksEntity> findAllBooksByAuthorId(AuthorEntity authorEntity);
}
