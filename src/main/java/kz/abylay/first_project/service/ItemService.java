package kz.abylay.first_project.service;

import kz.abylay.first_project.models.Items;

import java.util.List;

public interface ItemService {
    List<Items> getAllPhones();
    Items getPhone(int id);
    boolean addPhone(Items p);
    boolean editPhone(Items p);
    void deletePhone(Items p);
}
