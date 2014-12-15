package project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.entity.Genre;
import project.repository.GenreRepository;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Андрей on 10.12.2014.
 */
@Service
public class GenreService {
    @Autowired
    GenreRepository genreRepository;

    @Transactional
    public List<Genre> getAll() {
        List<Genre> genreList = new ArrayList<Genre>();
        for(Genre g : genreRepository.findAll()) {
            genreList.add(g);
        }
        return genreList;
    }

    @Transactional
    public Genre getOne(Integer id) {
        return genreRepository.findOne(id);
    }

    @Transactional
    public boolean delete(int id) {
        if(checkGenre(id)) {
            genreRepository.delete(id);
            return true;
        }
        return false;
    }

    @Transactional
    public Genre add(Genre g) {
        return genreRepository.save(g);
    }

    @Transactional
    public Genre update(Integer id, Genre g) {
        Genre updGenre = genreRepository.findOne(id);
        updGenre.setName(g.getName());
        return genreRepository.save(updGenre);
    }
    @Transactional
    public Genre getGenre(String name){
        return genreRepository.getGenre(name);
    }

    @Transactional
    public boolean checkGenre(Integer id){
        return genreRepository.checkGenre(id)==0;
    }
}
