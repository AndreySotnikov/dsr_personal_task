package project.entity;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Андрей on 06.12.2014.
 */
@Entity
public class Author {
    @Id
    @Column(name = "ID_AUTHOR")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idAuthor;
    private String family;
    private String name;
    private Integer year;
    //@ManyToMany(mappedBy="author", cascade = CascadeType.ALL) //
    @ManyToMany(mappedBy = "author")
    private Set<Book> book;

    public Author() {
    }

    public Author(String family, String name, Integer year) {
        this.family = family;
        this.name = name;
        this.year = year;
    }

    public String getFamily() {
        return family;
    }

    public Integer getIdAuthor() {
        return idAuthor;
    }

    public void setIdAuthor(Integer idAuthor) {
        this.idAuthor = idAuthor;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Set<Book> getBook() {
        return book;
    }

    public void setBook(Set<Book> book) {
        this.book = book;
    }

    @Override
    public String toString() {
        return "Author{" +
                "idAuthor=" + idAuthor +
                ", family='" + family + '\'' +
                ", name='" + name + '\'' +
                ", year=" + year +
                '}';
    }
}
