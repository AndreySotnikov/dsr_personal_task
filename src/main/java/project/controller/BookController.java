package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import project.dto.BookDto;
import project.entity.Author;
import project.entity.Book;
import project.entity.Genre;
import project.service.AuthorService;
import project.service.BookService;
import project.service.GenreService;
import project.service.OrderService;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Андрей on 11.12.2014.
 */
@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;
    @Autowired
    private AuthorService authorService;
    @Autowired
    private GenreService genreService;

    @RequestMapping("/all")
    public String getAll(ModelMap modelMap) {
        modelMap.addAttribute("bookList", bookService.getAll());
        return "books/all";
    }

//    @RequestMapping("/{id}")
//    public String getOne(@PathVariable Integer id, ModelMap modelMap) {
//        modelMap.addAttribute("order", orderService.getOne(id));
//        return "book/one";
//    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        bookService.delete(id);
        return "redirect:/book/all";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addForm(ModelMap modelMap) {
        modelMap.addAttribute("authorList", authorService.getAll());
        modelMap.addAttribute("genreList", genreService.getAll());
        return "books/addForm";
    }

    //    @RequestMapping(value = "/add", method = RequestMethod.POST)
//    public String add(@ModelAttribute("book") Book book,
//                      @RequestParam("genre") String genre,
//                      @RequestParam("authors") String[] authors)   {
//        book.setGenre(genreService.getGenre(genre));
//        Set<Author> author = new HashSet<Author>();
//        for (String auth : authors){
//            String[] temp = auth.split(" ");
//            author.add(authorService.getOne(Integer.parseInt(temp[0])));
//        }
//        book.setAuthor(author);
//        bookService.add(book);
//        return "redirect:/book/all";
//    }
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(@ModelAttribute("book") BookDto book) {
        bookService.add(book);
        return "redirect:/book/all";
    }


    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String updateForm(@PathVariable Integer id, ModelMap modelMap) {
        modelMap.addAttribute("book", bookService.getOne(id));
        modelMap.addAttribute("genreList", genreService.getAll());
        modelMap.addAttribute("authorList", authorService.getAll());
        return "books/updateForm";
    }

//    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
//    public String update(@PathVariable Integer id, @ModelAttribute("book") Book book,
//                         @RequestParam("genre") String genre,
//                         @RequestParam("authors") String[] authors) {
//        book.setGenre(genreService.getGenre(genre));
//        Set<Author> author = new HashSet<Author>();
//        for (String auth : authors){
//            String[] temp = auth.split(" ");
//            author.add(authorService.getOne(Integer.parseInt(temp[0])));
//        }
//        book.setAuthor(author);
//        bookService.update(id,book);
//        return "redirect:/book/all";
//    }
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public String update(@PathVariable Integer id, @ModelAttribute("book") BookDto book){
        bookService.update(id,book);
        return "redirect:/book/all";
    }
}
