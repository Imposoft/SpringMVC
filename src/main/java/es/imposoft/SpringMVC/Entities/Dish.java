package es.imposoft.SpringMVC.Entities;

import es.imposoft.SpringMVC.Model.AllergenDTO;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Dish {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id = 0;

    private String name;
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "section_id",nullable = false)
    private Section section;

    @ElementCollection
    @Enumerated(EnumType.STRING)
    private List<AllergenDTO> allergens;

    private double price;
    //TODO Implementar: Image image;

    public Dish(){}

    public Dish(String name, String description, List<AllergenDTO> allergens, double price) {
        this.name = name;
        this.description = description;
        this.allergens = allergens;
        this.price = price;
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

    public List<AllergenDTO> getAllergens() {
        return allergens;
    }

    public void setAllergens(List<AllergenDTO> allergens) {
        this.allergens = allergens;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setSection(Section section) {
        this.section = section;
    }

    public Section getSection() {
        return section;
    }
}
