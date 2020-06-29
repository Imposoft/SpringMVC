package es.imposoft.SpringMVC.Logic.Converter;

import es.imposoft.SpringMVC.Entities.Dish;
import es.imposoft.SpringMVC.Entities.Menu;
import es.imposoft.SpringMVC.Entities.Section;
import es.imposoft.SpringMVC.Model.DishDTO;
import es.imposoft.SpringMVC.Model.MenuDTO;
import es.imposoft.SpringMVC.Model.SectionDTO;

public class ConvertUtil {
    public static Menu convertMenu(MenuDTO menuToConvert){
        Menu convertedMenu = new Menu();
        convertedMenu.setName(menuToConvert.getName());
        convertedMenu.setDescription(menuToConvert.getDescription());
        for (SectionDTO sectionToConvert: menuToConvert.getSections()) {
            Section convertedSection = new Section();
            convertedSection.setName(sectionToConvert.getName());
            convertedSection.setDescription(sectionToConvert.getDescription());
            for (DishDTO dishToConvert:sectionToConvert.getDishes()) {
                Dish convertedDish = new Dish();
                convertedDish.setName(dishToConvert.getName());
                convertedDish.setDescription(dishToConvert.getDescription());
                convertedDish.setPrice(dishToConvert.getPrice());
                convertedDish.setAllergens(dishToConvert.getAllergens());
                convertedDish.setSection(convertedSection);
                convertedSection.addDish(convertedDish);
            }
            convertedSection.addMenu(convertedMenu);
            convertedMenu.addSection(convertedSection);
        }
        return convertedMenu;
    }

    public static MenuDTO convertMenuDTO(Menu menuToConvert) {
        MenuDTO convertedMenu = new MenuDTO();
        convertedMenu.setName(menuToConvert.getName());
        convertedMenu.setDescription(menuToConvert.getDescription());
        for (Section sectionToConvert: menuToConvert.getSections()) {
            SectionDTO convertedSection = new SectionDTO();
            convertedSection.setName(sectionToConvert.getName());
            convertedSection.setDescription(sectionToConvert.getDescription());
            for (Dish dishToConvert:sectionToConvert.getDishes()) {
                DishDTO convertedDish = new DishDTO();
                convertedDish.setName(dishToConvert.getName());
                convertedDish.setDescription(dishToConvert.getDescription());
                convertedDish.setPrice(dishToConvert.getPrice());
                convertedDish.setAllergens(dishToConvert.getAllergens());
                convertedSection.addDish(convertedDish);
            }
            convertedMenu.addSection(convertedSection);
        }
        return convertedMenu;
    }
}
