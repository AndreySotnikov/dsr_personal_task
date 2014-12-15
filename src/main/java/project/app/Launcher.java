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

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Андрей on 06.12.2014.
 */
public class Launcher {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(MainConfig.class, args);
        BookRepository bookRepository = context.getBean(BookRepository.class);
        GenreRepository genreRepository = context.getBean(GenreRepository.class);
        OrderRepository orderRepository = context.getBean(OrderRepository.class);
        AuthorRepository authorRepository = context.getBean(AuthorRepository.class);

        Genre g1 = new Genre("Программирование-Java");
        Genre g2 = new Genre("Программирование-Python");
        Genre g3 = new Genre("Программирование-C++");

        g1 = genreRepository.save(g1);
        g2 = genreRepository.save(g2);
        g3 = genreRepository.save(g3);

        Author a1 = new Author("Бьерн","Страуструп",1950);
        Author a2 = new Author("Хорстманн", "Кей",1960);
        Author a3 = new Author("Корнелл","Гари",1960);
        Author a4 = new Author("Эккель","Брюс",1957);
        Author a5 = new Author("Пилигрим", "Марк",1972);

        a1 = authorRepository.save(a1);
        a2 = authorRepository.save(a2);
        a3 = authorRepository.save(a3);
        a4 = authorRepository.save(a4);
        a5 = authorRepository.save(a5);

        Book b1 = new Book("Язык программирования С++", new HashSet<Author>(Arrays.asList(new Author[] {a1})),2013, g3, 1300, 1136);
        Book b2 = new Book("Java. Основы",new HashSet<Author>(Arrays.asList(new Author[] {a2,a3})),2013,g1,1200,896);
        Book b3 = new Book("Философия Java",new HashSet<Author>(Arrays.asList(new Author[] {a4})),2009,g1,800,640);
        Book b4 = new Book("Философия C++",new HashSet<Author>(Arrays.asList(new Author[] {a4})),2004,g3,900,608);
        Book b5 = new Book("Погружение в Python 3",new HashSet<Author>(Arrays.asList(new Author[] {a5})),2004,g2,600,168);

        b1 = bookRepository.save(b1);
        b2 = bookRepository.save(b2);
        b3 = bookRepository.save(b3);
        b4 = bookRepository.save(b4);
        b5 = bookRepository.save(b5);

        Order o1 = new Order("Иванов А",b1.getPrice()+b4.getPrice(),"15/12/2014",new HashSet<Book>(Arrays.asList(new Book[] {b1,b4})));
        Order o2 = new Order("Петров В",b2.getPrice()+b3.getPrice(),"14/12/2014",new HashSet<Book>(Arrays.asList(new Book[] {b2,b3})));
        Order o3 = new Order("Кузнецов А",b1.getPrice()+b3.getPrice()+b4.getPrice(),"13/12/2014" ,new HashSet<Book>(Arrays.asList(new Book[] {b1,b3,b4})));
        Order o4 = new Order("Волков С", b5.getPrice(),"12/12/2014" ,new HashSet<Book>(Arrays.asList(new Book[] {b5})));

        orderRepository.save(o1);
        orderRepository.save(o2);
        orderRepository.save(o3);
        orderRepository.save(o4);
    }
}
