package web.crud_springboot.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.crud_springboot.models.User;
import web.crud_springboot.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }


    @GetMapping
    public String index(Model model){
        model.addAttribute("users", service.findAll());
        return "users/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model){
        model.addAttribute("user", service.findById(id));
        return "users/show";
    }

    @GetMapping("/new")
    public String newUser(@ModelAttribute("user") User user){
        return "users/new";
    }

    @PostMapping
    public String create(@ModelAttribute("user") User user){

        service.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("user", service.findById(id));
        return "users/edit";
    }

    @PostMapping("/{id}/edit")
    public String update(@ModelAttribute("user") User user) {

        service.updateUser(user);
        return "redirect:/users";
    }

    @PostMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        service.deleteById(id);
        return "redirect:/users";
    }
}
