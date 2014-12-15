package project.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import project.entity.Book;

/**
 * Created by Андрей on 07.12.2014.
 */
public interface BookRepository extends CrudRepository<Book,Integer> {
    @Query(value = "select count(*) from BOOK_ORDER b where b.BOOK_ID_BOOK=:id",nativeQuery = true)
    public int checkBook(@Param("id") Integer id);

    @Query(value = "select sum(b.price) from BOOK b, BOOK_ORDER bo where (b.ID_BOOK=bo.BOOK_ID_BOOK and b.ID_BOOK=:id)", nativeQuery = true)
    public int sumProfit(@Param("id")Integer id);

}
