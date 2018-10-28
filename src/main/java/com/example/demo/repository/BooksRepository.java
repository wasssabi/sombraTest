package com.example.demo.repository;

import com.example.demo.entity.BooksEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BooksRepository extends JpaRepository<BooksEntity,Long> {

@Query(value = "SELECT distinct b.genre FROM BooksEntity b")
List<String> getDisGenres();
}
