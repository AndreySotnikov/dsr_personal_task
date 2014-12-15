package project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.entity.Author;
import project.entity.Genre;
import project.repository.AuthorRepository;
import project.repository.GenreRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Андрей on 11.12.2014.
 */
@Service
public class AuthorService {
    @Autowired
    AuthorRepository authorRepository;

    @Transactional
    public List<Author> getAll() {
        List<Author> authorList = new ArrayList<Author>();
        for(Author  a: authorRepository.findAll()) {
            authorList.add(a);
        }
        return authorList;
    }

    @Transactional
    public Author getOne(Integer id) {
        return authorRepository.findOne(id);
    }

    @Transactional
    public boolean delete(int id) {
        if (checkAuthor(id)) {
            authorRepository.delete(id);
            return true;
        }
        return false;
    }

    @Transactional
    public Author add(Author a) {
        return authorRepository.save(a);
    }

    @Transactional
    public Author update(Integer id, Author a) {
        Author updAuthor = authorRepository.findOne(id);
        updAuthor.setName(a.getName());
        updAuthor.setFamily(a.getFamily());
        updAuthor.setYear(a.getYear());
        return authorRepository.save(updAuthor);
    }

    @Transactional
    public boolean checkAuthor(Integer id){
        return authorRepository.checkAuthor(id)==0;
    }

    @Transactional
    public int sumProfit(Integer id){
        try{
            int profit = authorRepository.sumProfit(id);
            return profit;
        }catch(Throwable e){
            return 0;
        }
    }

    @Transactional
    public List<String> getGenres(Integer id){
        List<Genre> lst = new ArrayList<Genre>();
        return authorRepository.getGenres(id);
    }

    @Transactional
    public int minYear(Integer id){
        try{
            int minYear = authorRepository.minYear(id);
            return minYear;
        }catch(Throwable e){
            return 0;
        }
    }

    @Transactional
    public int maxYear(Integer id){
        try{
            int maxYear = authorRepository.maxYear(id);
            return maxYear;
        }catch(Throwable e){
            return 0;
        }
    }
}
