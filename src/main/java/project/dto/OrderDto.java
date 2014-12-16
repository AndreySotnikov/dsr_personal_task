package project.dto;

import project.entity.Book;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Arrays;
import java.util.Set;

/**
 * Created by Андрей on 14.12.2014.
 */
public class OrderDto {
    @Size(min = 5, message = "Поле \"ФИО\" должно быть длиннее 5 символов")
    private String FIO;
    @NotNull(message = "Заполните книги в заказах")
    private Integer[] books;
    @Size(min = 1, message = "Поле \"Дата\" не должно быть пустым")
    private String date;
    private Integer price;

    public String getFIO() {
        return FIO;
    }

    public void setFIO(String FIO) {
        this.FIO = FIO;
    }

    public Integer[] getBooks() {
        return books;
    }

    public void setBooks(Integer[] books) {
        this.books = books;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderDto)) return false;

        OrderDto orderDto = (OrderDto) o;

        if (FIO != null ? !FIO.equals(orderDto.FIO) : orderDto.FIO != null) return false;
        if (!Arrays.equals(books, orderDto.books)) return false;
        if (price != null ? !price.equals(orderDto.price) : orderDto.price != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = FIO != null ? FIO.hashCode() : 0;
        result = 31 * result + (books != null ? Arrays.hashCode(books) : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "OrderDto{" +
                "FIO='" + FIO + '\'' +
                ", books=" + Arrays.toString(books) +
                ", price=" + price +
                '}';
    }
}
