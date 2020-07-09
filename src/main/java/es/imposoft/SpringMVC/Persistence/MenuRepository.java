package es.imposoft.SpringMVC.Persistence;

import es.imposoft.SpringMVC.Entities.Menu;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MenuRepository extends CrudRepository<Menu, Integer> {
    Menu findMenuByName(String name);
    Menu findMenuById(int id);
    Menu findFirstByName(String name);
    List<Menu> findAll();
    Boolean existsById(int id);
}
