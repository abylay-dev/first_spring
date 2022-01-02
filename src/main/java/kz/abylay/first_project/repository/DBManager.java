package kz.abylay.first_project.repository;

import kz.abylay.first_project.models.Phone;

import java.util.ArrayList;
import java.util.List;

public class DBManager {
    private static List<Phone> phones = new ArrayList<>();
    private static int id = 1;

    static {
        phones.add(new Phone(id++, "iPhone 13", 500000, 25));
        phones.add(new Phone(id++, "Xiaomi Redmi 4x", 70000, 10));
        phones.add(new Phone(id++, "Samsung A52", 220000, 16));
    }

    public static List<Phone> getPhones(){
        return phones;
    }

    public static Phone getThePhone(int id){
        for (Phone p : phones){
            if (p.getId()==id){
                return p;
            }
        }
        return null;
    }

    public static void updatePhone(int id, String name, int price, int count){
        for (Phone p : phones){
            if (p.getId()==id){
                p.setName(name);
                p.setPrice(price);
                p.setAmount(count);
            }
        }
    }

    public static void deletePhone(int id) {
        for (Phone p : phones) {
            if (p.getId() == id) {
                phones.remove(p);
                break;
            }
        }
    }

    public static void addPhone(Phone p){
        phones.add(new Phone(id++, p.getName(), p.getPrice(), p.getAmount()));
    }
}
