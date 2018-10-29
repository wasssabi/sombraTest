package com.example.demo.service.impl;

import com.example.demo.entity.A_UDto;
import com.example.demo.entity.Auhor_BooksEntity;
import com.example.demo.entity.AuthorEntity;
import com.example.demo.entity.BooksEntity;
import com.example.demo.repository.Author_BooksRepository;
import com.example.demo.service.AuthorBookService;
import com.example.demo.service.AuthorService;
import com.example.demo.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class AuthorBookServiceImpl implements AuthorBookService {

    @Autowired
    private Author_BooksRepository author_booksRepository;
    @Autowired
    private AuthorService authorService;

    @Autowired
    private BooksService booksService;

    @Override
    public Auhor_BooksEntity getAuhorBooksEntity(Long id) {
        return author_booksRepository.getOne(id);
    }

    @Override
    public void create(A_UDto a_uDto) {
        Auhor_BooksEntity auhor_booksEntity = new Auhor_BooksEntity();
        auhor_booksEntity.setBook(booksService.getBook(a_uDto.getBookId()));
        auhor_booksEntity.setAuthor(authorService.getAuthor(a_uDto.getAuthorId()));
        author_booksRepository.save(auhor_booksEntity);
    }

    @Override
    public void update(Auhor_BooksEntity auhor_booksEntity) {
        author_booksRepository.save(auhor_booksEntity);
    }

    @Override
    public void delete(Long id) {
        author_booksRepository.deleteById(id);
    }

    @Override
    public List<Auhor_BooksEntity> getAll() {
        return author_booksRepository.findAll();
    }

    @Override
    public List<AuthorEntity> authorWithMostBooks() {

        List<Long> authorsIds = new ArrayList<>();

        author_booksRepository.findAll().forEach(auhor_booksEntity -> authorsIds.add(auhor_booksEntity.getAuthor().getId()));

        List<Long> resultIds = authorsIds.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .collect(Collectors.groupingBy(Map.Entry::getValue, Collectors.mapping(Map.Entry::getKey, Collectors.toList())))
                .entrySet().stream().max((o1, o2) -> o1.getKey().compareTo(o2.getKey())).map(Map.Entry::getValue)
                .orElse(Collections.emptyList());

        List<AuthorEntity> resultAuthors = new ArrayList<>();

        resultIds.forEach(aLong -> resultAuthors.add(authorService.getAuthor(aLong)));
        return resultAuthors;
    }

    @Override
    public List<BooksEntity> booksWithMoreThenOneAuthorWrittenBook() {
        List<Auhor_BooksEntity> auhor_booksEntities = author_booksRepository.findAll();
        List<Long> allAuthorIds = new ArrayList<>();
        List<Long> uniqueAuthorsIds = new ArrayList<>();
        List<List<BooksEntity>> result = new ArrayList<>();

        auhor_booksEntities.forEach(auhor_booksEntity ->
                allAuthorIds.add(auhor_booksEntity.getAuthor().getId()));


        allAuthorIds.stream().distinct().collect(Collectors.toList()).forEach(aLong -> {
            if (Collections.frequency(allAuthorIds, aLong) > 1) {
                uniqueAuthorsIds.add(aLong);
            }
        });


        uniqueAuthorsIds.forEach(aLong ->
                result.add(author_booksRepository.findAllBooksByAuthorId(authorService.getAuthor(aLong))));

        List<BooksEntity> booksEntities = new ArrayList<>();
        for (int i = 0; i < result.size(); i++) {
            for (int q = 0; q < result.get(i).size(); q++) {
                booksEntities.add(result.get(i).get(q));
            }
        }

        return booksEntities.stream().distinct().collect(Collectors.toList());
    }


}
