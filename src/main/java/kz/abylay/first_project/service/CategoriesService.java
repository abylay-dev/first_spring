package kz.abylay.first_project.service;

import kz.abylay.first_project.models.Categories;
import kz.abylay.first_project.models.Country;

import java.util.List;

public interface CategoriesService {
    List<Categories> getAllCategories();
    Categories getCategory(int id);
    boolean addCategory(Categories category);
}
