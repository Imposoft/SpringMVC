package es.imposoft.SpringMVC.Model;

import java.util.List;

public class MenuModel {
    private String menuText;

    List<SectionModel> sections;
    String name, description;
    int id;

    public MenuModel(List<SectionModel> sections, String name, String description, int id) {
        this.sections = sections;
        this.name = name;
        this.description = description;
        this.id = id;
    }

    public List<SectionModel> getSections() {
        return sections;
    }

    public void setSections(List<SectionModel> sections) {
        this.sections = sections;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public MenuModel(){
    }

    public MenuModel(String menuText){
        this.menuText = menuText;
    }

    public String getMenuText(){
        return menuText;
    }

    public void setMenuText(String menuText){
        this.menuText = menuText;
    }
}
