package project.dto;

import project.entity.Author;
import project.entity.Genre;
import project.entity.Order;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Андрей on 12.12.2014.
 */
public class BookDto {
    private String name;
    private Integer[] authors;
    private Integer year;
    private Integer genre;
    private Integer volume;
    //private Order[] order;

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

//    public Order[] getOrder() {
//        return order;
//    }
//
//    public void setOrder(Order[] order) {
//        this.order = order;
//    }

    @Override
    public String toString() {
        return "BookDto{" +
                "name='" + name + '\'' +
                ", author=" + authors +
                ", year=" + year +
                ", genre=" + genre +
                ", volume=" + volume +
               // ", order=" + order +
                '}';
    }
}
