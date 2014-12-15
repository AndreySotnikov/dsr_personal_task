package project.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import project.entity.Author;
import project.entity.Genre;

import java.util.List;

/**
 * Created by Андрей on 07.12.2014.
 */
public interface AuthorRepository extends CrudRepository<Author,Integer> {
    @Query(value = "select count(*) from BOOK_AUTHOR b where b.AUTHOR_ID_AUTHOR=:id",nativeQuery = true)
    public int checkAuthor(@Param("id") Integer id);

    @Query(value = "select sum(b.price) from BOOK b, BOOK_ORDER bo join BOOK_AUTHOR ba on b.ID_BOOK=ba.BOOK_ID_BOOK where (bo.BOOK_ID_BOOK=b.ID_BOOK and ba.AUTHOR_ID_AUTHOR=:id)", nativeQuery = true)
    public int sumProfit(@Param("id") Integer id);

    @Query(value = "select distinct g.NAME from GENRE g,BOOK b join BOOK_AUTHOR ba on b.ID_BOOK=ba.BOOK_ID_BOOK where (b.GENRE_ID=g.ID_GENRE and ba.AUTHOR_ID_AUTHOR=:id)", nativeQuery = true)
    public List<String> getGenres(@Param("id") Integer id);

    @Query(value = "select min(b.YEAR) from BOOK b join BOOK_AUTHOR ba on b.ID_BOOK=ba.BOOK_ID_BOOK where (ba.AUTHOR_ID_AUTHOR=:id)", nativeQuery = true)
    public int minYear(@Param("id") Integer id);

    @Query(value = "select max(b.YEAR) from BOOK b join BOOK_AUTHOR ba on b.ID_BOOK=ba.BOOK_ID_BOOK where (ba.AUTHOR_ID_AUTHOR=:id)", nativeQuery = true)
    public int maxYear(@Param("id") Integer id);
}
