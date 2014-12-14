package project.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import project.entity.Author;

/**
 * Created by Андрей on 07.12.2014.
 */
public interface AuthorRepository extends CrudRepository<Author,Integer> {
    @Query(value = "select count(*) from BOOK_AUTHOR b where b.AUTHOR_ID_AUTHOR=:id",nativeQuery = true)
    public int checkAuthor(@Param("id") Integer id);
}
