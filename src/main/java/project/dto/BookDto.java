package project.dto;

import project.entity.Author;
import project.entity.Genre;
import project.entity.Order;
import project.validator.ValidYear;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Arrays;
import java.util.Set;

/**
 * Created by Андрей on 12.12.2014.
 */
public class BookDto {
    @Size(min = 3, message = "Поле \"Название\" должно быть длиннее 3 символов")
    private String name;
    @NotNull(message = "Заполните авторов книги")
    private Integer[] authors;
    @NotNull(message = "Поле \"Год издания\" не должно быть пустым")
    @ValidYear(message = "Некорректный год")
    private Integer year;
    private Integer genre;
    @NotNull(message = "Поле \"Объем\" не должно быть пустым")
    private Integer volume;
    @NotNull(message = "Поле \"Цена\" не должно быть пустым")
    private Integer price;
    private Integer[] order;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer[] getAuthors() {
        return authors;
    }

    public void setAuthors(Integer[] authors) {
        this.authors = authors;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getGenre() {
        return genre;
    }

    public void setGenre(Integer genre) {
        this.genre = genre;
    }

    public Integer getVolume() {
        return volume;
    }

    public void setVolume(Integer volume) {
        this.volume = volume;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

        public Integer[] getOrder() {
        return order;
    }

    public void setOrder(Integer[] order) {
        this.order = order;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BookDto)) return false;

        BookDto bookDto = (BookDto) o;

        if (!Arrays.equals(authors, bookDto.authors)) return false;
        if (genre != null ? !genre.equals(bookDto.genre) : bookDto.genre != null) return false;
        if (name != null ? !name.equals(bookDto.name) : bookDto.name != null) return false;
        if (!Arrays.equals(order, bookDto.order)) return false;
        if (price != null ? !price.equals(bookDto.price) : bookDto.price != null) return false;
        if (volume != null ? !volume.equals(bookDto.volume) : bookDto.volume != null) return false;
        if (year != null ? !year.equals(bookDto.year) : bookDto.year != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (authors != null ? Arrays.hashCode(authors) : 0);
        result = 31 * result + (year != null ? year.hashCode() : 0);
        result = 31 * result + (genre != null ? genre.hashCode() : 0);
        result = 31 * result + (volume != null ? volume.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (order != null ? Arrays.hashCode(order) : 0);
        return result;
    }

    @Override
    public String toString() {
        return "BookDto{" +
                "name='" + name + '\'' +
                ", author=" + authors +
                ", year=" + year +
                ", genre=" + genre +
                ", volume=" + volume +
                ", order=" + order +
                '}';
    }
}
