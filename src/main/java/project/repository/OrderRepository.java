package project.repository;

import org.springframework.data.repository.CrudRepository;
import project.entity.Order;

/**
 * Created by Андрей on 08.12.2014.
 */
public interface OrderRepository extends CrudRepository<Order,Integer> {
}
