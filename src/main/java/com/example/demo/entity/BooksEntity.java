package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "books")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class BooksEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    public String name;

    @Column(name = "published")
    private LocalDate published;

    @Column(name = "genre")
    private String genre;

    @Column(name = "rating")
    private Integer rating;

    @JsonIgnore
    @OneToMany(
            mappedBy = "author"
    )
    private List<Auhor_BooksEntity> auhor_booksEntities = new ArrayList<>();

}
