package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import project.entity.Author;
import project.entity.Book;
import project.entity.Genre;
import project.service.AuthorService;
import project.service.GenreService;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by Андрей on 11.12.2014.
 */
@Controller
@RequestMapping("/author")
public class AuthorController {
    @Autowired
    AuthorService authorService;
    private int delError=0;
    @RequestMapping("/all")
    public String all(ModelMap modelMap){
        modelMap.addAttribute("authorList", authorService.getAll());
        modelMap.addAttribute("error",delError);
        delError=0;
        return "authors/all";
    }

    @RequestMapping("/{id}")
    public String getOne(@PathVariable Integer id, ModelMap modelMap) {
        modelMap.addAttribute("author", authorService.getOne(id));
        return "redirect:/author/all";
    }

    @RequestMapping("/show/{id}")
    public String showOne(@PathVariable Integer id, ModelMap modelMap){
        Author author = authorService.getOne(id);
        modelMap.addAttribute("author", author);
        modelMap.addAttribute("sum", authorService.sumProfit(id));
        modelMap.addAttribute("genres", authorService.getGenres(id));
        modelMap.addAttribute("minYear", authorService.minYear(id));
        modelMap.addAttribute("maxYear", authorService.maxYear(id));
        return "authors/one";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable Integer id, ModelMap modelMap) {
        if(!authorService.delete(id))
            delError=1;
        return "redirect:/author/all";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addForm() {
        return "authors/addForm";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(@ModelAttribute("author") @Valid Author author, BindingResult bindingResult, ModelMap modelMap)  {
        if (bindingResult.hasErrors()) {
            List<String> validationErrors = new ArrayList<String>();
            for (FieldError error : bindingResult.getFieldErrors()) {
                validationErrors.add(error.getDefaultMessage());
            }
            modelMap.addAttribute("errors", validationErrors);
            return "authors/addForm";
        }
        authorService.add(author);
        return "redirect:/author/all";
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String updateForm(@PathVariable Integer id, ModelMap modelMap) {
        modelMap.addAttribute("author", authorService.getOne(id));
        return "authors/addForm";
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public String update(@PathVariable Integer id,
                         @ModelAttribute("author") @Valid Author author, BindingResult bindingResult, ModelMap modelMap) {
        if (bindingResult.hasErrors()) {
            List<String> validationErrors = new ArrayList<String>();
            for (FieldError error : bindingResult.getFieldErrors()) {
                validationErrors.add(error.getDefaultMessage());
            }
            modelMap.addAttribute("errors", validationErrors);
            return "authors/addForm";
        }
        authorService.update(id, author);
        return "redirect:/author/all";
    }
}
