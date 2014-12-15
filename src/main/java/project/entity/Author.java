package project.entity;

import project.validator.ValidYear;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
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
    @Size(min = 3, message = "Поле \"Фамилия\" должно быть длиннее 3 символов")
    private String family;
    @Size(min = 3, message = "Поле \"Имя\" должно быть длиннее 3 символов")
    private String name;
    @NotNull(message = "Поле \"Год рождения\" не должно быть пустым")
    @ValidYear(message = "Некорректный год")
    private Integer year;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Author)) return false;

        Author author = (Author) o;

        if (book != null ? !book.equals(author.book) : author.book != null) return false;
        if (family != null ? !family.equals(author.family) : author.family != null) return false;
        if (idAuthor != null ? !idAuthor.equals(author.idAuthor) : author.idAuthor != null) return false;
        if (name != null ? !name.equals(author.name) : author.name != null) return false;
        if (year != null ? !year.equals(author.year) : author.year != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idAuthor != null ? idAuthor.hashCode() : 0;
        result = 31 * result + (family != null ? family.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (year != null ? year.hashCode() : 0);
        return result;
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
