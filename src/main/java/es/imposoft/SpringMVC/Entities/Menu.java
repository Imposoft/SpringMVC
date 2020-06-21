package es.imposoft.SpringMVC.Entities;

import javax.persistence.*;

@Entity
@Table
public class Menu {
    @Id
    @GeneratedValue(strategy= GenerationType.TABLE)
    private Integer id;
    private String menuText;

    public Menu(){
    }

    public Menu(String menuText){
        this.menuText = menuText;
    }

    public int getId(){
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMenuText(){
        return menuText;
    }

    public void setMenuText(String menuText){
        this.menuText = menuText;
    }
}
