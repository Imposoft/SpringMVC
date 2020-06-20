package es.imposoft.SpringMVC.Entities;

import javax.persistence.*;

@Entity
@Table
public class Menu {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private String menuText;

    public Menu(){
    }

    public Menu(String menuText){
        this.id = 0;
        this.menuText = menuText;
    }

    public Menu(int id, String menuText){
        this.id = id;
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
