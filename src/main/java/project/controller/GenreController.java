package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import project.entity.Genre;
import project.service.GenreService;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Андрей on 10.12.2014.
 */
@Controller
@RequestMapping("/genre")
public class GenreController {
    @Autowired
    GenreService genreService;
    private int delError=0;

    @RequestMapping("/all")
    public String all(ModelMap map){
        map.addAttribute("genreList", genreService.getAll());
        map.addAttribute("error",delError);
        delError=0;
        return "genres/all";
    }

    @RequestMapping("/{id}")
    public String getOne(@PathVariable Integer id, ModelMap modelMap) {
        modelMap.addAttribute("genre", genreService.getOne(id));
        return "redirect:/genre/all";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        if(!genreService.delete(id))
            delError = 1;
        return "redirect:/genre/all";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addForm() {
        return "genres/addForm";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(@ModelAttribute("genre") @Valid Genre genre, BindingResult bindingResult, ModelMap modelMap)  {
        if (bindingResult.hasErrors()) {
			List<String> validationErrors = new ArrayList<String>();
			for (FieldError error : bindingResult.getFieldErrors()) {
				validationErrors.add(error.getDefaultMessage());
			}
			modelMap.addAttribute("errors", validationErrors);
			return "genres/addForm";
		}
        genreService.add(genre);
        return "redirect:/genre/all";
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String updateForm(@PathVariable Integer id, ModelMap modelMap) {
        modelMap.addAttribute("genre", genreService.getOne(id));
        return "genres/addForm";
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)   //!!!!!!
    public String update(@PathVariable Integer id,
                         @ModelAttribute("genre") @Valid Genre genre, BindingResult bindingResult, ModelMap modelMap) {
        if (bindingResult.hasErrors()) {
            List<String> validationErrors = new ArrayList<String>();
            for (FieldError error : bindingResult.getFieldErrors()) {
                validationErrors.add(error.getDefaultMessage());
            }
            modelMap.addAttribute("errors", validationErrors);
            return "genres/addForm";
        }
        genreService.update(id, genre);
        return "redirect:/genre/all";
    }
}
