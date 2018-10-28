package com.example.demo.repository;

import com.example.demo.entity.Auhor_BooksEntity;
import com.example.demo.entity.AuthorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<AuthorEntity,Long> {
    List<AuthorEntity> findAllByBornIsBefore(LocalDate localDate);
}
