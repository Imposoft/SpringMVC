package es.imposoft.SpringMVC.Entities;

import es.imposoft.SpringMVC.Model.SectionModel;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Menu {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id = 0;

    private String name;
    private String description;

    public Menu(){
    }

    public Menu(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Menu(String menuText){
        this.id = 0;
    }

    public int getId(){
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

    public String getMenuText(){
        return description;
    }
}
