package project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.dto.BookDto;
import project.entity.Author;
import project.entity.Book;
import project.repository.AuthorRepository;
import project.repository.BookRepository;
import project.repository.GenreRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Андрей on 07.12.2014.
 */
@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;
    @Autowired
    GenreRepository genreRepository;
    @Autowired
    AuthorRepository authorRepository;

    @Transactional
    public Book add(Book book){
        return bookRepository.save(book);
    }

    @Transactional
    public Book add(BookDto book){
        Book newBook = new Book();
        newBook.setGenre(genreRepository.findOne(book.getGenre()));
        newBook.setName(book.getName());
        newBook.setYear(book.getYear());
        newBook.setVolume(book.getVolume());
        newBook.setPrice(book.getPrice());
        Set<Author> set = new HashSet<Author>();
        for(Integer i : book.getAuthors()){
            set.add(authorRepository.findOne(i));
        }
        newBook.setAuthor(set);
        return bookRepository.save(newBook);
    }

    @Transactional
    public boolean delete(Integer id){
        if(checkBook(id)) {
            bookRepository.delete(id);
            return true;
        }
        return false;
    }

    @Transactional
    public Book getOne(Integer id){
        return bookRepository.findOne(id);
    }

    @Transactional
    public List<Book> getAll() {
        List<Book> books = new ArrayList<Book>();
        for(Book book : bookRepository.findAll()) {
            books.add(book);
        }
        return books;
    }

    @Transactional
    public Book update(Integer id, Book book){
        Book updBook = bookRepository.findOne(id);
        updBook.setAuthor(book.getAuthor());
        updBook.setGenre(book.getGenre());
        updBook.setOrder(book.getOrder());
        updBook.setYear(book.getYear());
        return bookRepository.save(book);
    }

    @Transactional
    public Book update(Integer id, BookDto book){
        Book updBook = bookRepository.findOne(id);
        updBook.setGenre(genreRepository.findOne(book.getGenre()));
        updBook.setName(book.getName());
        updBook.setYear(book.getYear());
        updBook.setVolume(book.getVolume());
        updBook.setPrice(book.getPrice());
        Set<Author> set = new HashSet<Author>();
        for(Integer i : book.getAuthors()){
            set.add(authorRepository.findOne(i));
        }
        updBook.setAuthor(set);
        return bookRepository.save(updBook);
    }

    @Transactional
    public boolean checkBook(Integer id){
        return bookRepository.checkBook(id)==0;
    }

    @Transactional
    public int sumProfit(Integer id){
        try{
            int profit = bookRepository.sumProfit(id);
            return profit;
        }catch(Throwable e){
            return 0;
        }
    }
}
