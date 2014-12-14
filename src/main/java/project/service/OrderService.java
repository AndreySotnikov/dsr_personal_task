package project.service;

import org.springframework.beans.factory.annotation.Autowired;
import project.entity.Book;
import project.entity.Order;
import project.repository.BookRepository;
import project.repository.OrderRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Андрей on 08.12.2014.
 */
public class OrderService {
    @Autowired
    OrderRepository orderRepository;

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
}
