package kz.abylay.first_project.service;

import kz.abylay.first_project.models.Phone;

import java.util.List;

public interface PhoneService {
    List<Phone> getAllPhones();
    Phone getPhone(int id);
    boolean addPhone(Phone p);
    boolean editPhone(int id, Phone p);
}
