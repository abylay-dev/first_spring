package kz.abylay.first_project.service.impl;

import kz.abylay.first_project.models.Items;
import kz.abylay.first_project.repository.ItemsRepository;
import kz.abylay.first_project.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {
//    region DBManager(commented)
//    private DBManager dbManager;
//
//    @Autowired
//    public ItemServiceImpl(DBManager dbManager) {
//        this.dbManager = dbManager;
//    }
//    endregion

    private ItemsRepository repository;
    @Autowired
    public ItemServiceImpl(ItemsRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Items> getAllPhones() {
        return repository.findAll();
    }

    @Override
    public Items getPhone(int id) {
        return repository.getById(id);
    }

    @Override
    public boolean addPhone(Items p) {
        Items addedItems = repository.save(p);
        return addedItems != null;
    }

    @Override
    public boolean editPhone(Items p) {
        Items addedItems = repository.save(p);
        return addedItems != null;
    }

    @Override
    public void deletePhone(Items p) {
        repository.delete(p);
    }
}
