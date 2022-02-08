package kz.abylay.first_project.service.impl;

import kz.abylay.first_project.models.Phone;
import kz.abylay.first_project.repository.PhoneRepository;
import kz.abylay.first_project.service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhoneServiceImpl implements PhoneService {
//    region DBManager(commented)
//    private DBManager dbManager;
//
//    @Autowired
//    public PhoneServiceImpl(DBManager dbManager) {
//        this.dbManager = dbManager;
//    }
//    endregion

    private PhoneRepository repository;
    @Autowired
    public PhoneServiceImpl(PhoneRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Phone> getAllPhones() {
        return repository.findAll();
    }

    @Override
    public Phone getPhone(int id) {
        return repository.getById(id);
    }

    @Override
    public boolean addPhone(Phone p) {
        Phone addedPhone = repository.save(p);
        return addedPhone != null;
    }

    @Override
    public boolean editPhone(int id, Phone p) {
        p.setId(id);
        Phone addedPhone = repository.save(p);
        return addedPhone != null;
    }

    @Override
    public void deletePhone(Phone p) {
        repository.delete(p);
    }
}
