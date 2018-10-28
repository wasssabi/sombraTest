package com.example.demo.controller;

import com.example.demo.entity.AuthorEntity;
import com.example.demo.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @PostMapping
    public void createAuthor(@RequestBody AuthorEntity authorEntity){
        authorService.createAuthor(authorEntity);
    }

    @PutMapping("/{id}")
    public void updateAuthor(@PathVariable Long id,
                                     @RequestBody AuthorEntity newAuthor){
        AuthorEntity authorEntity = authorService.getAuthor(id);
        authorEntity.setName(newAuthor.getName());
        authorEntity.setBorn(newAuthor.getBorn());
        authorEntity.setGender(newAuthor.getGender());

        authorService.updateAuthor(authorEntity);
    }

    @GetMapping
    public List<AuthorEntity> getAll(){
        return  authorService.getAuthors();
    }

    @GetMapping("/{id}")
    public AuthorEntity findOne(@PathVariable Long id){
        return authorService.getAuthor(id);
    }

    @DeleteMapping("/{id}")
    public void deleteOne(@PathVariable Long id){
        authorService.deleteAuthor(id);
    }

    @GetMapping("/older")
    public List<AuthorEntity>  findOlderThen55() {
       return authorService.findOlderThen55AndSortThem();
    }

}
