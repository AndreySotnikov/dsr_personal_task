package project.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import project.entity.Genre;

/**
 * Created by Андрей on 07.12.2014.
 */
public interface GenreRepository extends CrudRepository<Genre,Integer> {
    @Query("select g from Genre g where  g.name=:name")
    Genre getGenre(@Param("name") String name);

    @Query(value = "select count(*) from BOOK b where b.GENRE_ID=:id",nativeQuery = true)
    public int checkGenre(@Param("id") Integer id);
}
