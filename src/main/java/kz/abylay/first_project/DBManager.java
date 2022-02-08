package kz.abylay.first_project;

import kz.abylay.first_project.models.Phone;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Repository
public class DBManager {
    private List<Phone> phones = new ArrayList<>();
    private int id = 1;

    @PostConstruct
    public void myInit() {
        phones.add(new Phone(id++, "iPhone 13", 500000, 25));
        phones.add(new Phone(id++, "Xiaomi Redmi 4x", 70000, 10));
        phones.add(new Phone(id++, "Samsung A52", 220000, 16));
    }

    public List<Phone> getPhones(){
        return phones;
    }

    public Phone getThePhone(int id){
        for (Phone p : phones){
            if (p.getId()==id){
                return p;
            }
        }
        return null;
    }

    public boolean updatePhone(int id, String name, int price, int count){
        for (Phone p : phones){
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
        for (Phone p : phones) {
            if (p.getId() == id) {
                phones.remove(p);
                break;
            }
        }
    }

    public boolean addPhone(Phone p){
        if (p!=null) {
            phones.add(p);
            p.setId(id++);
            return true;
        }
        return false;
    }
}
