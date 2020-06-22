package es.imposoft.SpringMVC.Entities;

import es.imposoft.SpringMVC.Model.DishModel;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Section {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id = 0;

    private String name;
    private String description;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Menu> menus = new ArrayList<>();

    public Section(){}

    public Section(String name, String description, List<Menu> menu) {
        this.name = name;
        this.description = description;
        this.menus = menu;
    }

    public Section(String name, String description, Menu menu) {
        this.name = name;
        this.description = description;
        this.menus.add(menu);
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

    public List<Menu> getMenu() {
        return menus;
    }

    public void setMenu(Menu menu) {
        menus.add(menu);
    }
}
