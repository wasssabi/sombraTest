package com.example.demo.service.impl;

import com.example.demo.entity.BooksEntity;
import com.example.demo.repository.BooksRepository;
import com.example.demo.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
@Service
public class BooksServiceImpl implements BooksService {
    @Autowired
    private BooksRepository bookRepository;

    @Override
    public BooksEntity getBook(Long id) {
        return bookRepository.getOne(id);
    }

    @Override
    public void createBook(BooksEntity booksEntity) {
    bookRepository.save(booksEntity);
    }

    @Override
    public void deleteBook(Long id) {
    bookRepository.deleteById(id);
    }

    @Override
    public void updateBook(BooksEntity booksEntity) {
    bookRepository.save(booksEntity);
    }

    @Override
    public List<BooksEntity> findAll() {
        return bookRepository.findAll();
    }



    @Override
    public List<String> calcNumberOfBooksByGenre() {
        List<BooksEntity> booksEntities = bookRepository.findAll();
        List<String> allGenres = new ArrayList<>();
        for (int i=0;i<booksEntities.size();i++){
            allGenres.add(booksEntities.get(i).getGenre());
        }
        List<String > distinctGenres = bookRepository.getDisGenres();
        List<String> amountOfGanres = new ArrayList<>();
        for (int i=0;i<distinctGenres.size();i++){
            amountOfGanres.add("Genre :"+distinctGenres.get(i)+"" +
                    "    "+"Ammount :"+ Collections.frequency(allGenres,distinctGenres.get(i)));
        }

        return amountOfGanres;
    }
}
