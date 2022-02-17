package kz.abylay.first_project;

import kz.abylay.first_project.models.Items;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DBManager {
    private List<Items> items = new ArrayList<>();
    private int id = 1;

    /*@PostConstruct
    public void myInit() {
        items.add(new Items(id++, "iPhone 13", 500000, 25));
        items.add(new Items(id++, "Xiaomi Redmi 4x", 70000, 10));
        items.add(new Items(id++, "Samsung A52", 220000, 16));
    }*/

    public List<Items> getPhones(){
        return items;
    }

    public Items getThePhone(int id){
        for (Items p : items){
            if (p.getId()==id){
                return p;
            }
        }
        return null;
    }

    public boolean updatePhone(int id, String name, int price, int count){
        for (Items p : items){
            if (p.getId()==id){
                p.setName(name);
                p.setPrice(price);
                p.setAmount(count);
                return true;
            }
        }
        return false;
    }

    public void deletePhone(int id) {
        for (Items p : items) {
            if (p.getId() == id) {
                items.remove(p);
                break;
            }
        }
    }

    public boolean addPhone(Items p){
        if (p!=null) {
            items.add(p);
            p.setId(id++);
            return true;
        }
        return false;
    }
}
