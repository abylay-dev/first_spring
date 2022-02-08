package kz.abylay.first_project.controllers;

import groovy.transform.AutoImplement;
import kz.abylay.first_project.models.Phone;

import kz.abylay.first_project.service.PhoneService;
import kz.abylay.first_project.service.impl.PhoneServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import kz.abylay.first_project.repository.DBManager;

import java.util.List;

@Controller
public class MyController {

    private PhoneService service;

    @Autowired
    public MyController(PhoneService service) {
        this.service = service;
    }

    @GetMapping
    public String getIndex(Model model){
        List<Phone> phones = service.getAllPhones();
        model.addAttribute("title", "Home");
        model.addAttribute("items", phones);
        /*p.setName("Xiaomi");
        model.addAttribute("phone", p);*/
        return "first_page";
    }

    /*@GetMapping(value = "/smartphones")
    public List<Phone> getPhones(){
        return DBManager.getPhones();
    }

    @PostMapping(value = "/phone")
    public boolean phone(@RequestBody Phone p){
        System.out.println(p.toString());
        DBManager.addPhone(p);
        return p != null;

    }*/

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
            return "redirect:/errorpage/404";
        }
        service.addPhone(new Phone(null, name, price, amount));
        return "redirect:/add";
    }
    ///edit/1
    @GetMapping("/edit/{idshka}")
    public String getEditPhonePage(/*HttpServletRequest request*/
        @PathVariable(name="idshka") int id, Model model
    ){
//        int id = request.getParameter("id");
        Phone p = service.getPhone(id);
        if (p == null){
            return "redirect:/errorpage/500";
        }
        model.addAttribute("phone", p);
        return "edit";
    }

    @PostMapping(value = "/editPhone/{idshka}")
    public String edit(@PathVariable(name="idshka") int id,
                       @RequestParam(name = "phone_name", defaultValue = "No item") String name,
                       @RequestParam(name = "phone_price", defaultValue = "0") int price,
                       @RequestParam(name = "phone_amount", defaultValue = "0") int amount
    ){
        service.editPhone(id, new Phone(id, name, price, amount));
        return "redirect:/";
    }

    @GetMapping("/errorpage/{error_id}") /* {error_id} = 500 */
    public String getError(Model model, @PathVariable(name = "error_id") int errorID){
        if (errorID==500){
            model.addAttribute("error", "500 ITEM NOT FOUND");
        }else if (errorID==404){
            model.addAttribute("error", "404 PAGE NOT FOUND");
        }
        return "error_page";
    }
}
