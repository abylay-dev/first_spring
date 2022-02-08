package kz.abylay.first_project.service.impl;

import kz.abylay.first_project.models.Phone;
import kz.abylay.first_project.repository.DBManager;
import kz.abylay.first_project.service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhoneServiceImpl implements PhoneService {

    private DBManager dbManager;

    @Autowired
    public PhoneServiceImpl(DBManager dbManager) {
        this.dbManager = dbManager;
    }

    @Override
    public List<Phone> getAllPhones() {
        return dbManager.getPhones();
    }

    @Override
    public Phone getPhone(int id) {
        return dbManager.getThePhone(id);
    }

    @Override
    public boolean addPhone(Phone p) {
        return dbManager.addPhone(p);
    }

    @Override
    public boolean editPhone(int id, Phone p) {
        return dbManager.updatePhone(id, p.getName(), p.getPrice(), p.getAmount());
    }
}
