package es.imposoft.SpringMVC.Persistence;

import es.imposoft.SpringMVC.Entities.Menu;
import org.springframework.data.repository.CrudRepository;

public interface MenuRepository extends CrudRepository<Menu, Integer> {
    Menu findMenuByMenuText(String textMenu);
}
