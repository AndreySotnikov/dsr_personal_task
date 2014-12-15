package project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.dto.OrderDto;
import project.entity.Author;
import project.entity.Book;
import project.entity.Order;
import project.repository.AuthorRepository;
import project.repository.BookRepository;
import project.repository.OrderRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Андрей on 08.12.2014.
 */
@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    BookRepository bookRepository;

    @Transactional
    public Order add(Order order){
        return orderRepository.save(order);
    }

    @Transactional
    public List<Order> getAll() {
        List<Order> orders = new ArrayList<Order>();
        for(Order order : orderRepository.findAll()) {
            orders.add(order);
        }
        return orders;
    }

    @Transactional
    public void delete(Integer id){
        orderRepository.delete(id);
    }

    @Transactional
    public Order getOne(Integer id){
        return orderRepository.findOne(id);
    }

    @Transactional
    public Order add(OrderDto order){
        Order newOrder = new Order();
        newOrder.setFIO(order.getFIO());
        Set<Book> set = new HashSet<Book>();
        int sum=0;
        for(Integer i : order.getBooks()){
            set.add(bookRepository.findOne(i));
        }
        for (Book b : set){
            sum+=b.getPrice();
        }
        newOrder.setPrice(sum);
        newOrder.setBook(set);
        newOrder.setDate(order.getDate());
        return orderRepository.save(newOrder);
    }

    @Transactional
    public Order update(Integer id,OrderDto order){
        Order updOrder = orderRepository.findOne(id);
        int sum=0;
        updOrder.setFIO(order.getFIO());
        Set<Book> set = new HashSet<Book>();
        for(Integer i : order.getBooks()){
            set.add(bookRepository.findOne(i));
        }
        for (Book b : set){
            sum+=b.getPrice();
        }
        updOrder.setPrice(sum);
        updOrder.setBook(set);
        updOrder.setDate(order.getDate());
        return orderRepository.save(updOrder);
    }
}
