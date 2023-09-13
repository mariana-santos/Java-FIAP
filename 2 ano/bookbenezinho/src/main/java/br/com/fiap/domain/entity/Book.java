package br.com.fiap.domain.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.*;

@Entity
@Table(name = "TB_BOOK", uniqueConstraints = {
        @UniqueConstraint(name = "UK_ISBN_BOOK", columnNames = "ISBN_BOOK")
})
public class Book {

    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_BOOK")
    @Id
    @Column(name = "ID_BOOK")
    private Long id;

    @Column(name = "NM_BOOK", nullable = false)
    private String name;

    @Column(name = "ISBN_BOOK", nullable = false)
    private String ISBN;

    @Column(name = "RELEASE_DATE_BOOK", nullable = false)
    private LocalDate releaseDate;

    @ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(
            name = "TB_BOOK_AUTHOR",
            joinColumns = {
                    @JoinColumn(
                            name = "BOOK",
                            referencedColumnName = "ID_BOOK",
                            foreignKey = @ForeignKey(name = "FK_BOOK_AUTHOR"))
            },
            inverseJoinColumns = {
                    @JoinColumn(
                            name = "AUTHOR",
                            referencedColumnName = "ID_AUTHOR",
                            foreignKey = @ForeignKey(name = "FK_AUTHOR_BOOK")
                    )
            }
    )
    private Set<Author> writers;

    public Book(String name, String ISBN, LocalDate releaseDate, Set<Author> writers) {
        this.name = name;
        this.ISBN = ISBN;
        this.releaseDate = releaseDate;
        this.writers = Objects.nonNull(writers) ? writers : new LinkedHashSet<>();
    }

    public Book(){
        this.writers = new LinkedHashSet<>();
    }

    public Book addAuthor(Author a){
        this.writers.add(a);
        return this;
    }

    public Book removeAuthor(Author a){
        this.writers.remove(a);
        return this;
    }

    public Long getId() {
        return id;
    }

    public Book setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Book setName(String name) {
        this.name = name;
        return this;
    }

    public String getISBN() {
        return ISBN;
    }

    public Book setISBN(String ISBN) {
        this.ISBN = ISBN;
        return this;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public Book setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
        return this;
    }

    public Set<Author> getWriters() {
        return Collections.unmodifiableSet(writers);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", ISBN='" + ISBN + '\'' +
                ", releaseDate=" + releaseDate +
                ", writers=" + writers +
                '}';
    }
}
