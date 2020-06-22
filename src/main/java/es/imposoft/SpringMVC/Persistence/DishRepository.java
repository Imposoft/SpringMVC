package es.imposoft.SpringMVC.Persistence;

import es.imposoft.SpringMVC.Entities.Dish;
import es.imposoft.SpringMVC.Entities.Section;
import org.springframework.data.repository.CrudRepository;

public interface DishRepository extends CrudRepository<Dish, Integer> {
}
