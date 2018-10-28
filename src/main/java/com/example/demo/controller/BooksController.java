package com.example.demo.controller;

import com.example.demo.entity.BooksEntity;
import com.example.demo.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/books")
public class BooksController {

    @Autowired
    private BooksService booksService;

    @GetMapping
    public List<BooksEntity> findAll(){
         return booksService.findAll();
    }

    @GetMapping("/{id}")
    public BooksEntity findOne(@PathVariable Long id){
        return booksService.getBook(id);
    }

    @PostMapping
    public void createBook(@RequestBody BooksEntity booksEntity){
        booksService.createBook(booksEntity);
    }

    @PutMapping("/{id}")
    public void updateBook(@PathVariable Long id,@RequestBody BooksEntity newBook){
        BooksEntity booksEntity =booksService.getBook(id);
        booksEntity.setName(newBook.getName());
        booksEntity.setPublished(newBook.getPublished());
        booksEntity.setGenre(newBook.getGenre());
        booksEntity.setRating(newBook.getRating());

        booksService.updateBook(booksEntity);
    }
    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id){
        booksService.deleteBook(id);
    }

    @GetMapping("/number")
    public List<String> getNumberOfBooksByGenre(){

        return booksService.calcNumberOfBooksByGenre();
    }


}
