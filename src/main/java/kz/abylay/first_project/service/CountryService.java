package kz.abylay.first_project.service;

import kz.abylay.first_project.models.Country;

import java.util.List;

public interface CountryService {
    List<Country> getAllCountries();
    Country getCountry(int id);
    boolean addCountry(Country c);
    boolean editCountry(int id, Country c);
    void deleteCountry(Country c);
}
