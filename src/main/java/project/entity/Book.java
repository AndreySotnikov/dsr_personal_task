package project.entity;

import javax.persistence.*;
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

    @ManyToMany
    @JoinTable(name="BOOK_AUTHOR", joinColumns={@JoinColumn(referencedColumnName="ID_BOOK")}
            , inverseJoinColumns={@JoinColumn(referencedColumnName="ID_AUTHOR")})
    private Set<Author> author;
    private Integer year;

    @ManyToOne
    @JoinColumn(name="GENRE_ID")
    private Genre genre;
    private Integer volume;
    private Integer price;

    @ManyToMany(mappedBy = "book")
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

    public Book(String name, Set<Author> author, Integer year, Genre genre, Integer price, Integer volume) {
        this.name = name;
        this.author = author;
        this.year = year;
        this.genre = genre;
        this.volume = volume;
        this.price = price;
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

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;

        Book book = (Book) o;

        if (author != null ? !author.equals(book.author) : book.author != null) return false;
        if (genre != null ? !genre.equals(book.genre) : book.genre != null) return false;
        if (idBook != null ? !idBook.equals(book.idBook) : book.idBook != null) return false;
        if (name != null ? !name.equals(book.name) : book.name != null) return false;
        if (order != null ? !order.equals(book.order) : book.order != null) return false;
        if (price != null ? !price.equals(book.price) : book.price != null) return false;
        if (volume != null ? !volume.equals(book.volume) : book.volume != null) return false;
        if (year != null ? !year.equals(book.year) : book.year != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idBook != null ? idBook.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + (year != null ? year.hashCode() : 0);
        result = 31 * result + (genre != null ? genre.hashCode() : 0);
        result = 31 * result + (volume != null ? volume.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (order != null ? order.hashCode() : 0);
        return result;
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
