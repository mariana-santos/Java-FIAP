package br.com.fiap.domain.entity;

import jakarta.persistence.*;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "TB_AUTHOR")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_AUTHOR")
    @Column(name = "ID_AUTHOR")
    private Long id;

    @Column(name = "NM_AUTHOR", nullable = false)
    private String name;

    @ManyToMany(mappedBy = "writers")
    @OrderBy("NAME ASC")
    private Set<Book> books;

    public Author(String name) {
        this.name = name;
    }

    public Author(){
        books = new LinkedHashSet<>();
    }

    public Long getId() {
        return id;
    }

    public Author setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Author setName(String name, Set<Book> books) {
        this.name = name;
        this.books = Objects.nonNull(books) ? books : new LinkedHashSet<>();
        return this;
    }

    public Set<Book> getBooks() {
        return Collections.unmodifiableSet(books);
    }

    public Author setBooks(Set<Book> books) {
        this.books = books;
        return this;
    }

    public Author addBook(Book b){
        books.add(b);
        return this;
    }

    public Author removeBook(Book b){
        books.remove(b);
        return this;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
