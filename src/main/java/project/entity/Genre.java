package project.entity;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Set;

/**
 * Created by Андрей on 07.12.2014.
 */
@Entity
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idGenre;
    @Size(min = 3, message = "Поле \"Название\" должно быть длиннее 3 символов")
    private String name;

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Genre)) return false;

        Genre genre = (Genre) o;

        if (book != null ? !book.equals(genre.book) : genre.book != null) return false;
        if (idGenre != null ? !idGenre.equals(genre.idGenre) : genre.idGenre != null) return false;
        if (name != null ? !name.equals(genre.name) : genre.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idGenre != null ? idGenre.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Genre{" +
                "idGenre=" + idGenre +
                ", name='" + name + '\'' +
                '}';
    }

}
