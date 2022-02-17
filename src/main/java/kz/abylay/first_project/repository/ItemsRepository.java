package kz.abylay.first_project.repository;

import kz.abylay.first_project.models.Items;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemsRepository extends JpaRepository<Items, Integer> {
    //List<Items> findAllByNameExists(String name);
}
