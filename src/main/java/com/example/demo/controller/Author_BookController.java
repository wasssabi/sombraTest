package com.example.demo.controller;


import com.example.demo.entity.A_UDto;
import com.example.demo.entity.Auhor_BooksEntity;
import com.example.demo.entity.AuthorEntity;
import com.example.demo.entity.BooksEntity;
import com.example.demo.service.AuthorBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/authorbook")
public class Author_BookController {

    @Autowired
    private AuthorBookService authorBookService;


    @GetMapping
    public List<Auhor_BooksEntity> findAll(){


        return authorBookService.getAll();
    }
    @GetMapping("/{id}")
    public Auhor_BooksEntity findOne(@PathVariable Long id){
        return authorBookService.getAuhorBooksEntity(id);
    }


    @PostMapping
    public void setAythorBook(@RequestBody A_UDto a_uDto){

        authorBookService.create(a_uDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        authorBookService.delete(id);
    }

    @GetMapping("/authorsmostbook")
    public List<AuthorEntity> getAuthorWithMostBooks(){
        return authorBookService.authorWithMostBooks();
    }

    @GetMapping("/booksmorethenone")
    public  List<BooksEntity> getBooksWithMoreThenOneAuthorWrittenBook(){
       return authorBookService.booksWithMoreThenOneAuthorWrittenBook();
    }




    }

