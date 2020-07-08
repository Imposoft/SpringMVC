package es.imposoft.SpringMVC.Models;

import java.util.ArrayList;
import java.util.List;

public class SectionDTO {

    int id;
    String name, description;
    List<DishDTO> dishes;

    public SectionDTO() {
        this.dishes = new ArrayList<>();
    }

    public SectionDTO(int id, String name, String description, List<DishDTO> dishes) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.dishes = new ArrayList<>();
        this.dishes = dishes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<DishDTO> getDishes() {
        return dishes;
    }

    public void setDishes(List<DishDTO> dishes) {
        this.dishes = dishes;
    }

    public void addDish(DishDTO convertedDish) {
        this.dishes.add(convertedDish);
    }
}
