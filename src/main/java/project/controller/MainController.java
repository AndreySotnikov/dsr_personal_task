package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import project.entity.Book;
import project.service.BookService;

import java.util.List;

/**
 * Created by Андрей on 07.12.2014.
 */
@Controller
@RequestMapping("/books")
public class MainController {
    @Autowired
    private BookService bookService;

    @RequestMapping("")
    public String getAll(ModelMap modelMap) {
        List<Book> books = bookService.getAll();
        modelMap.addAttribute("bookList", books);
        return "books/all";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addForm() {
        return "books/addForm";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(@ModelAttribute("book") Book book)  {
        bookService.add(book);
        return "redirect:/book";
    }

}
