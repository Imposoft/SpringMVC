package es.imposoft.SpringMVC.Model;


import java.awt.*;
import java.util.List;

public class DishDTO {

    int id;
    String name, description;
    List<AllergenDTO> allergens;
    double price;
    Image image;

    public DishDTO(int id, String name, String description, List<AllergenDTO> allergens, double price, Image image) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.allergens = allergens;
        this.price = price;
        this.image = image;
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

    public List<AllergenDTO> getAllergens() {
        return allergens;
    }

    public void setAllergens(List<AllergenDTO> allergens) {
        this.allergens = allergens;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
}
