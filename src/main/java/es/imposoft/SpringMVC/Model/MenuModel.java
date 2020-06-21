package es.imposoft.SpringMVC.Model;

public class MenuModel {
    private String menuText;

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
