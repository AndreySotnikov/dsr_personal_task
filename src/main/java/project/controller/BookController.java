package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import project.dto.BookDto;
import project.entity.Author;
import project.entity.Book;
import project.entity.Genre;
import project.service.AuthorService;
import project.service.BookService;
import project.service.GenreService;
import project.service.OrderService;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
    private int delError=0;

    @RequestMapping("/all")
    public String getAll(ModelMap modelMap) {
        modelMap.addAttribute("bookList", bookService.getAll());
        modelMap.addAttribute("error",delError);
        delError=0;
        return "books/all";
    }

    @RequestMapping("/show/{id}")
    public String showOne(@PathVariable Integer id, ModelMap modelMap){
        modelMap.addAttribute("book",bookService.getOne(id));
        modelMap.addAttribute("profit",bookService.sumProfit(id));
        return  "books/one";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        if(!bookService.delete(id))
            delError = 1;
        return "redirect:/book/all";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addForm(ModelMap modelMap) {
        modelMap.addAttribute("authorList", authorService.getAll());
        modelMap.addAttribute("genreList", genreService.getAll());
        return "books/addForm";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(@ModelAttribute("book") @Valid BookDto book, BindingResult bindingResult, ModelMap modelMap) {
        if (bindingResult.hasErrors()) {
            List<String> validationErrors = new ArrayList<String>();
            for (FieldError error : bindingResult.getFieldErrors()) {
                validationErrors.add(error.getDefaultMessage());
            }
            modelMap.addAttribute("authorList", authorService.getAll());
            modelMap.addAttribute("genreList", genreService.getAll());
            modelMap.addAttribute("errors", validationErrors);
            return "books/addForm";
        }
        bookService.add(book);
        return "redirect:/book/all";
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String updateForm(@PathVariable Integer id, ModelMap modelMap) {
        modelMap.addAttribute("book", bookService.getOne(id));
        modelMap.addAttribute("genreList", genreService.getAll());
        modelMap.addAttribute("authorList", authorService.getAll());
        return "books/addForm";
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public String update(@PathVariable Integer id, @ModelAttribute("book") @Valid BookDto book, BindingResult bindingResult, ModelMap modelMap){
        if (bindingResult.hasErrors()) {
            List<String> validationErrors = new ArrayList<String>();
            for (FieldError error : bindingResult.getFieldErrors()) {
                validationErrors.add(error.getDefaultMessage());
            }
            modelMap.addAttribute("authorList", authorService.getAll());
            modelMap.addAttribute("genreList", genreService.getAll());
            modelMap.addAttribute("errors", validationErrors);
            return "books/addForm";
        }
        bookService.update(id,book);
        return "redirect:/book/all";
    }
}
