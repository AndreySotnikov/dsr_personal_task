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
import project.dto.BookDto;
import project.dto.OrderDto;
import project.entity.Order;
import project.service.AuthorService;
import project.service.BookService;
import project.service.GenreService;
import project.service.OrderService;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Андрей on 14.12.2014.
 */
@Controller
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private BookService bookService;
    @Autowired
    private OrderService orderService;

    @RequestMapping("/all")
    public String getAll(ModelMap modelMap) {
        modelMap.addAttribute("orderList", orderService.getAll());
        return "orders/all";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        orderService.delete(id);
        return "redirect:/order/all";
    }

    @RequestMapping("/show/{id}")
    public String showOne(@PathVariable Integer id, ModelMap modelMap){
        modelMap.addAttribute("order",orderService.getOne(id));
        return  "orders/one";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addForm(ModelMap modelMap) {
        modelMap.addAttribute("bookList", bookService.getAll());
        return "orders/addForm";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(@ModelAttribute("order") @Valid OrderDto order, BindingResult bindingResult, ModelMap modelMap) {
        if (bindingResult.hasErrors()) {
            List<String> validationErrors = new ArrayList<String>();
            for (FieldError error : bindingResult.getFieldErrors()) {
                validationErrors.add(error.getDefaultMessage());
            }
            modelMap.addAttribute("errors", validationErrors);
            modelMap.addAttribute("bookList", bookService.getAll());
            return "orders/addForm";
        }
        orderService.add(order);
        return "redirect:/order/all";
    }


    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String updateForm(@PathVariable Integer id, ModelMap modelMap) {
        modelMap.addAttribute("order", orderService.getOne(id));
        modelMap.addAttribute("bookList", bookService.getAll());
        return "orders/addForm";
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public String update(@PathVariable Integer id, @ModelAttribute("order") @Valid OrderDto order, BindingResult bindingResult, ModelMap modelMap){
        if (bindingResult.hasErrors()) {
            List<String> validationErrors = new ArrayList<String>();
            for (FieldError error : bindingResult.getFieldErrors()) {
                validationErrors.add(error.getDefaultMessage());
            }
            modelMap.addAttribute("bookList", bookService.getAll());
            modelMap.addAttribute("errors", validationErrors);
            return "orders/addForm";
        }
        orderService.update(id,order);
        return "redirect:/order/all";
    }
}
