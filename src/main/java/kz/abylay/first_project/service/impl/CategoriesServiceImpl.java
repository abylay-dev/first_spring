package kz.abylay.first_project.service.impl;

import kz.abylay.first_project.models.Categories;
import kz.abylay.first_project.repository.CategoriesRepository;
import kz.abylay.first_project.service.CategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriesServiceImpl implements CategoriesService {
    @Autowired
    private CategoriesRepository repository;

    @Override
    public List<Categories> getAllCategories() {
        return repository.findAll();
    }

    @Override
    public Categories getCategory(int id) {
        return repository.getById(id);
    }

    @Override
    public boolean addCategory(Categories category) {
        return repository.save(category)!=null;
    }
}
