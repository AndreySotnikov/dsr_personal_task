package project.repository;

import org.springframework.data.repository.CrudRepository;
import project.entity.Book;

/**
 * Created by Андрей on 07.12.2014.
 */
public interface BookRepository extends CrudRepository<Book,Integer> {
}
