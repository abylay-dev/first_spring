package kz.abylay.first_project.controllers;

import kz.abylay.first_project.models.Phone;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import kz.abylay.first_project.repository.DBManager;
import java.util.List;

@Controller
public class MyController {

    @GetMapping("/")
    public String getIndex(Model model){
        List<Phone> phones = DBManager.getPhones();
        model.addAttribute("title", "Home");
        model.addAttribute("items", phones);
        return "first_page";
    }



}
