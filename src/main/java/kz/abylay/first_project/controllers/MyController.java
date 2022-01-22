package kz.abylay.first_project.controllers;

import kz.abylay.first_project.models.Phone;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import kz.abylay.first_project.repository.DBManager;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;
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

    @GetMapping("/add")
    public String getAddPhonePage(Model model/*, @RequestParam(name="error") String error*/){
        /*if (error==null){
            model.addAttribute("error", "No input data");
        }*/
        model.addAttribute("title", "Add phone");
        return "addPhone";
    }

    @PostMapping(value = "/addPhone")
    public String addPhone(/*HttpServletRequest request,*/
                @RequestParam(name = "phone_name", defaultValue = "No item") String name,
               @RequestParam(name = "phone_price", defaultValue = "0") int price,
               @RequestParam(name = "phone_amount", defaultValue = "0") int amount
    ){
        //String name = request.getParameter("phone_name");
        //int price = Integer.parseInt(request.getParameter("phone_price"));
        if (name.equals("No item")){
            /*return "redirect:/add?error=1";*/
            return "redirect:/errorpage";
        }
        DBManager.addPhone(new Phone(null, name, price, amount));
        return "redirect:/add";
    }
    ///edit/1
    @GetMapping("/edit/{idshka}")
    public String getEditPhonePage(/*HttpServletRequest request*/
        @PathVariable(name="idshka") int id, Model model
    ){
//        int id = request.getParameter("id");
        Phone p = DBManager.getThePhone(id);
        model.addAttribute("phone", p);
        return "edit";
    }

    @PostMapping(value = "/editPhone/{idshka}")
    public String edit(@PathVariable(name="idshka") int id,
                       @RequestParam(name = "phone_name", defaultValue = "No item") String name,
                       @RequestParam(name = "phone_price", defaultValue = "0") int price,
                       @RequestParam(name = "phone_amount", defaultValue = "0") int amount
    ){
        DBManager.updatePhone(id, name, price, amount);
        return "redirect:/";
    }

    @GetMapping("/errorpage")
    public String getError(Model model){
        return "error_page";
    }
}
