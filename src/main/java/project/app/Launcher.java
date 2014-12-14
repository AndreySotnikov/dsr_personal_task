package project.app;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import project.entity.Author;
import project.entity.Book;
import project.entity.Genre;
import project.entity.Order;
import project.repository.AuthorRepository;
import project.repository.BookRepository;
import project.repository.GenreRepository;
import project.repository.OrderRepository;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Андрей on 06.12.2014.
 */
public class Launcher {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(MainConfig.class, args);
//        BookRepository bookRepository = context.getBean(BookRepository.class);
//        GenreRepository genreRepository = context.getBean(GenreRepository.class);
//        OrderRepository orderRepository = context.getBean(OrderRepository.class);
//        AuthorRepository authorRepository = context.getBean(AuthorRepository.class);
//        Set setAuthors = new HashSet<Author>();
//        Set setBook = new HashSet<Book>();
//        Set setBook2 = new HashSet<Book>();
//        Set setOrder = new HashSet<Order>();
//
//        Genre genre = new Genre("gen1");
//        Genre genre2 = new Genre("gen2");
//        Order order = new Order("Client1",3);
//        setOrder.add(order);
//
//
//        Author a1 = new Author("author1", "name1", 1900);
//        Author a2 = new Author("author2", "name2", 1910);
//
//        Set<Author> auth = new HashSet<Author>(Arrays.asList(new Author("f1","n1",2000)));
//        //authorRepository.save(a1);
//        //authorRepository.save(a2);
//
//        setAuthors.add(a1);
//        setAuthors.add(a2);
//
//        Book book = new Book("aaaaa",100,2000);
//        setBook.add(book);
//        //setBook2.add(book);
//        genre.setBook(setBook);
//        genre2.setBook(setBook2);
//
//        order.setBook(setBook);
//        book.setOrder(setOrder);
//        book.setGenre(genre);
//        book.setAuthor(setAuthors);
////        genreRepository.save(genre);
////        genreRepository.save(genre2);
//
//        bookRepository.save(new Book("book",auth,1995,genre2,300));
//        bookRepository.save(book);
//        orderRepository.save(order);
//        authorRepository.save(a1);
//        authorRepository.save(a2);
    }
}
