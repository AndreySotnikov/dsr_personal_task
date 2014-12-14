package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import project.entity.Author;
import project.entity.Book;
import project.entity.Genre;
import project.service.AuthorService;
import project.service.GenreService;

import java.util.HashSet;

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
    public String add(@ModelAttribute("Author") Author author)  {
        authorService.add(author);
        return "redirect:/author/all";
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String updateForm(@PathVariable Integer id, ModelMap modelMap) {
        modelMap.addAttribute("author", authorService.getOne(id));
        return "authors/updateForm";
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)   //!!!!!!
    public String update(@PathVariable Integer id,
                         @ModelAttribute("author") Author author) {
        author.setBook(new HashSet<Book>());
        authorService.update(id, author);
        return "redirect:/author/all";
    }
}
