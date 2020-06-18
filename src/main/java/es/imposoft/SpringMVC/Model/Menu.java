package es.imposoft.SpringMVC.Model;

public class Menu {
    private String menuText;

    public Menu(){
    }

    public Menu(String menuText){
        this.menuText = menuText;
    }

    public String getMenuText(){
        return menuText;
    }

    public void setMenuText(String menuText){
        this.menuText = menuText;
    }
}
