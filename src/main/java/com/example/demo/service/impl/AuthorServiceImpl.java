package com.example.demo.service.impl;

import com.example.demo.entity.AuthorEntity;
import com.example.demo.repository.AuthorRepository;
import com.example.demo.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public AuthorEntity getAuthor(Long id) {
        return authorRepository.getOne(id);
    }

    @Override
    public void createAuthor(AuthorEntity authorEntity) {
        authorRepository.save(authorEntity);
    }

    @Override
    public void deleteAuthor(Long id) {
        authorRepository.deleteById(id);
    }

    @Override
    public void updateAuthor(AuthorEntity authorEntity) {
        authorRepository.save(authorEntity);
    }

    @Override
    public List<AuthorEntity> getAuthors() {
        return authorRepository.findAll();
    }


    @Override
    public List<AuthorEntity> findOlderThen55AndSortThem() {
        LocalDate localDate =LocalDate.now().minusYears(55).plusDays(1);
        List<AuthorEntity> list = authorRepository.findAllByBornIsBefore(localDate);
        list.sort((o1,o2) -> o1.getBorn().compareTo(o2.getBorn()));
        return list;
    }



}
