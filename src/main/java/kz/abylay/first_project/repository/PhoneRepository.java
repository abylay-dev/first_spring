package kz.abylay.first_project.repository;

import kz.abylay.first_project.models.Phone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PhoneRepository extends JpaRepository<Phone, Integer> {
    //List<Phone> findAllByNameExists(String name);
}
