package kz.abylay.first_project.service.impl;

import kz.abylay.first_project.models.Country;
import kz.abylay.first_project.repository.CountryRepository;
import kz.abylay.first_project.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {
    @Autowired
    private CountryRepository repository;

    @Override
    public List<Country> getAllCountries() {
        return repository.findAll();
    }

    @Override
    public Country getCountry(int id) {
        return repository.getById(id);
    }

    @Override
    public boolean addCountry(Country c) {
        Country country = repository.save(c);
        return country!=null;
    }

    @Override
    public boolean editCountry(int id, Country c) {
        Country country = repository.save(c);
        return country!=null;
    }

    @Override
    public void deleteCountry(Country c) {
        repository.delete(c);
    }
}
