package es.imposoft.SpringMVC.Entities;

import es.imposoft.SpringMVC.Model.DishDTO;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "section")
public class Section {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id = 0;

    private String name;
    private String description;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "section")
    private List<Dish> dishes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "menu_id",nullable = false)
    private Menu menu;

    public Section(){
        dishes = new ArrayList<>();
    }

    public Section(String name, String description, List<Dish> dishes) {
        this.name = name;
        this.description = description;
        for (Dish dish:dishes) {
            dish.setSection(this);
        }
        this.dishes = new ArrayList<>();
        this.dishes = dishes;
    }

    public Section(String name, String description, Dish dish) {
        this.name = name;
        this.description = description;
        dishes = new ArrayList<>();
        this.dishes.add(dish);
    }

    public void addDish(Dish dish){
        dishes.add(dish);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public void setDishes(Dish dish) {
        dishes.add(dish);
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public void addMenu(Menu menu) {
        this.menu = menu;
    }

    public Menu getMenu() {
        return menu;
    }
}
