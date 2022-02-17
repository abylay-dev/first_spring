package kz.abylay.first_project.controllers;

import kz.abylay.first_project.models.Categories;
import kz.abylay.first_project.models.Country;
import kz.abylay.first_project.models.Items;

import kz.abylay.first_project.service.CategoriesService;
import kz.abylay.first_project.service.CountryService;
import kz.abylay.first_project.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MyController {

    private ItemService itemService;

    @Autowired
    public MyController(ItemService service) {
        this.itemService = service;
    }

    @Autowired
    private CountryService countryService;

    @Autowired
    private CategoriesService categoriesService;


    @GetMapping
    public String getIndex(Model model){
        List<Items> items = itemService.getAllPhones();
        model.addAttribute("title", "Home");
        model.addAttribute("items", items);
        /*p.setName("Xiaomi");
        model.addAttribute("phone", p);*/
        return "first_page";
    }

    /*@GetMapping(value = "/smartphones")
    public List<Items> getPhones(){
        return DBManager.getPhones();
    }

    @PostMapping(value = "/phone")
    public boolean phone(@RequestBody Items p){
        System.out.println(p.toString());
        DBManager.addPhone(p);
        return p != null;

    }*/

    @GetMapping("/add")
    public String getAddPhonePage(Model model/*, @RequestParam(name="error") String error*/){
        /*if (error==null){
            model.addAttribute("error", "No input data");
        }*/
        model.addAttribute("countries", countryService.getAllCountries());
        model.addAttribute("title", "Add phone");
        return "addPhone";
    }

    @PostMapping(value = "/addPhone")
    public String addPhone(/*HttpServletRequest request,*/
                @RequestParam(name = "item_name", defaultValue = "No item") String name,
               @RequestParam(name = "item_price", defaultValue = "0") int price,
               @RequestParam(name = "item_amount", defaultValue = "0") int amount,
               @RequestParam(name = "country_id", defaultValue = "-1") int country_id
    ){
        //String name = request.getParameter("phone_name");
        //int price = Integer.parseInt(request.getParameter("phone_price"));
        if (name.equals("No item")){
            /*return "redirect:/add?error=1";*/
            return "redirect:/errorpage/404";
        }
        Country country = countryService.getCountry(country_id);
        if(country != null) {
            itemService.addPhone(new Items(null, name, price, amount, country, null));
        }
        return "redirect:/add";
    }
    ///edit/1
    @GetMapping("/edit/{idshka}")
    public String getEditPhonePage(/*HttpServletRequest request*/
        @PathVariable(name="idshka") int id, Model model
    ){
//        int id = request.getParameter("id");
        Items p = itemService.getPhone(id);
        if (p == null){
            return "redirect:/errorpage/500";
        }
        model.addAttribute("item", p);
        model.addAttribute("categories", categoriesService.getAllCategories());
        return "edit";
    }

    @PostMapping(value = "/editPhone/{idshka}")
    public String edit(@PathVariable(name="idshka") int id,
                       @RequestParam(name = "item_name", defaultValue = "No item") String name,
                       @RequestParam(name = "item_price", defaultValue = "0") int price,
                       @RequestParam(name = "item_amount", defaultValue = "0") int amount
    ){
        //service.editPhone(id, new Items(id, name, price, amount));
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

    @PostMapping("/assigncategory")
    public String assignCategory(@RequestParam(name = "item_id")int itemID,
                                 @RequestParam(name = "category_id")int categoryID){
        Categories category = categoriesService.getCategory(categoryID);
        if (category!=null){
            Items item = itemService.getPhone(itemID);
            if (item!=null){
                List<Categories> categories = item.getCategories();
                if(categories==null){
                    categories = new ArrayList<>();
                }
                categories.add(category);
                boolean tf = itemService.editPhone(item);
                if (tf){
                    return "redirect:/edit/" + itemID;
                }
            }
        }
        return "redirect:/";
    }
}
