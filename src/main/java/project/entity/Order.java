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
    private Integer count;
    @ManyToMany(mappedBy = "order",cascade = CascadeType.ALL) //
    private Set<Book> book;

    public Order(String FIO, Integer count) {
        this.FIO = FIO;
        this.count = count;
    }

    public Order() {
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

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Set<Book> getBook() {
        return book;
    }

    public void setBook(Set<Book> book) {
        this.book = book;
    }
}
