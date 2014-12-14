package project.entity;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import javax.persistence.*;
import java.util.Set;

/**
 * Created by Андрей on 07.12.2014.
 */
@Entity
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idGenre;
    private String name;

    //@OneToMany(mappedBy = "genre",cascade = CascadeType.ALL,orphanRemoval = true) //
    @OneToMany(mappedBy = "genre")
    private Set<Book> book;

    public Genre() {
    }

    public Genre(String name) {
        this.name = name;
    }

    public Integer getIdGenre() {
        return idGenre;
    }

    public void setIdGenre(Integer idGenre) {
        this.idGenre = idGenre;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Book> getBook() {
        return book;
    }

    public void setBook(Set<Book> book) {
        this.book = book;
    }


    @Override
    public String toString() {
        return "Genre{" +
                "idGenre=" + idGenre +
                ", name='" + name + '\'' +
                '}';
    }

}
