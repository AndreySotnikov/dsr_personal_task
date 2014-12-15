package project.entity;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Андрей on 08.12.2014.
 */
@Entity
@Table(name = "Order_table")
public class Order {
    @Id
    @Column(name = "ID_ORDER")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idOrder;
    private String FIO;
    private Integer price;
    private String date;
    @ManyToMany
    @JoinTable(name="BOOK_ORDER", joinColumns={@JoinColumn(referencedColumnName="ID_ORDER")}
            , inverseJoinColumns={@JoinColumn(referencedColumnName="ID_BOOK")})
    private Set<Book> book;

    public Order(String FIO, Integer price) {
        this.FIO = FIO;
        this.price = price;
    }

    public Order() {
    }

    public Order(String FIO, Integer price, Set<Book> book) {
        this.FIO = FIO;
        this.price = price;
        this.book = book;
    }

    public Order(String FIO, Set<Book> book) {
        this.book = book;
        this.FIO = FIO;
    }

    public Order(String FIO, Integer price, String date, Set<Book> book) {
        this.FIO = FIO;
        this.price = price;
        this.date = date;
        this.book = book;
    }

    public Integer getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(Integer idOrder) {
        this.idOrder = idOrder;
    }

    public String getFIO() {
        return FIO;
    }

    public void setFIO(String FIO) {
        this.FIO = FIO;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Set<Book> getBook() {
        return book;
    }

    public void setBook(Set<Book> book) {
        this.book = book;
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
        if (!(o instanceof Order)) return false;

        Order order = (Order) o;

        if (FIO != null ? !FIO.equals(order.FIO) : order.FIO != null) return false;
        if (book != null ? !book.equals(order.book) : order.book != null) return false;
        if (idOrder != null ? !idOrder.equals(order.idOrder) : order.idOrder != null) return false;
        if (price != null ? !price.equals(order.price) : order.price != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idOrder != null ? idOrder.hashCode() : 0;
        result = 31 * result + (FIO != null ? FIO.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Order{" +
                "idOrder=" + idOrder +
                ", FIO='" + FIO + '\'' +
                ", price=" + price +
                ", book=" + book +
                '}';
    }
}
