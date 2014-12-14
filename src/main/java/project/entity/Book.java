package project.entity;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Андрей on 07.12.2014.
 */
@Entity
public class Book {
    @Id
    @Column(name="ID_BOOK")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer idBook;
    private String name;
    //@ManyToMany(cascade=CascadeType.ALL)
    @ManyToMany
    @JoinTable(name="BOOK_AUTHOR", joinColumns={@JoinColumn(referencedColumnName="ID_BOOK")}
            , inverseJoinColumns={@JoinColumn(referencedColumnName="ID_AUTHOR")})
    private Set<Author> author;
    private Integer year;
    //@ManyToOne(cascade = CascadeType.ALL) //
    @ManyToOne
    @JoinColumn(name="GENRE_ID")
    private Genre genre;
    private Integer volume;
    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(name="BOOK_ORDER", joinColumns={@JoinColumn(referencedColumnName="ID_BOOK")}
            , inverseJoinColumns={@JoinColumn(referencedColumnName="ID_ORDER")})
    private Set<Order> order;

    public Book() {
    }

    public Book(String name, Integer volume, Integer year) {
        this.name = name;
        this.volume = volume;
        this.year = year;
    }

    public Book(String name, Set<Author> author, Integer year, Genre genre, Integer volume) {
        this.name = name;
        this.author = author;
        this.year = year;
        this.genre = genre;
        this.volume = volume;
    }

    public Integer getId() {
        return idBook;
    }

    public void setId(Integer idBook) {
        this.idBook = idBook;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Author> getAuthor() {
        return author;
    }

    public void setAuthor(Set<Author> author) {
        this.author = author;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }


    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Integer getVolume() {
        return volume;
    }

    public void setVolume(Integer volume) {
        this.volume = volume;
    }

    public Integer getIdBook() {
        return idBook;
    }

    public void setIdBook(Integer idBook) {
        this.idBook = idBook;
    }

    public Set<Order> getOrder() {
        return order;
    }

    public void setOrder(Set<Order> order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + idBook +
                ", name='" + name + '\'' +
                ", author=" + author +
                ", year=" + year +
                ", genre=" + genre +
                ", volume=" + volume +
                '}';
    }
}
