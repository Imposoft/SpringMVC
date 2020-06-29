package es.imposoft.SpringMVC.Entities;

import es.imposoft.SpringMVC.Model.MenuDTO;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Menu {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id = 0;

    private String name;
    private String description;

    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL,mappedBy = "menu")
    private List<Section> sections;

    public Menu(){
        sections = new ArrayList<>();
    }

    public Menu(String name, String description,Section section) {
        this.name = name;
        this.description = description;
        sections = new ArrayList<>();
        section.addMenu(this);
        this.sections.add(section);
    }

    public Menu(String name, String description,List<Section> sections) {
        this.name = name;
        this.description = description;
        for (Section section:sections) {
            section.addMenu(this);
        }
        this.sections = sections;
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

    public List<Section> getSections() {
        return sections;
    }

    public void addSection(Section sections) {
        this.sections.add(sections);
    }

    public void setSections(List<Section> sections) {
        this.sections = sections;
    }
}
