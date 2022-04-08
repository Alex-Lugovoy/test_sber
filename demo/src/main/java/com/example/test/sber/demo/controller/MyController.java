package com.example.test.sber.demo.controller;

import com.example.test.sber.demo.entity.Human;
import com.example.test.sber.demo.service.HumanServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class MyController {

    @Autowired
    private HumanServiceImp humanServiceImp;

    @GetMapping("/")
    public String show_list_people(Model model) {
        List<Human> humans = humanServiceImp.getAllHumans();
        model.addAttribute("humans", humans);
        return "list_people";
    }

    @GetMapping("/human/new")
    public String add_human(Model model) {
        model.addAttribute("newHuman", new Human());
        return "newHuman";
    }

    @PostMapping("/human/save")
    public String save_human(@ModelAttribute("newHuman") @Valid Human human, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "newHuman";
        humanServiceImp.save(human);
        return "redirect:/";
    }

    @GetMapping ("/human/delete/{id}")
    public String delete_human(@PathVariable("id")int id) {
        try {
            humanServiceImp.delete(id);
        }
        catch (EmptyResultDataAccessException e){
            return "redirect:/";
        }
        return "redirect:/";
    }

    @GetMapping ("/human/update/{id}")
    public String update_human(@PathVariable("id")int id, Model model) {
        Human human = humanServiceImp.getHuman(id);
        model.addAttribute("newHuman", human);
        return "newHuman";
    }
}
