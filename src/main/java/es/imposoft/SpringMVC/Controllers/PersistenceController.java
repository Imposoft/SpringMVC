package es.imposoft.SpringMVC.Controllers;

import es.imposoft.SpringMVC.Logic.Converter.ConvertUtil;
import es.imposoft.SpringMVC.Models.Greeting;
import es.imposoft.SpringMVC.Entities.Menu;
import es.imposoft.SpringMVC.Models.MenuDTO;
import es.imposoft.SpringMVC.Persistence.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class PersistenceController {
    @Autowired // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    private MenuRepository menuRepository;

    @GetMapping("/testMenu")
    public Menu testMenu() {
        return new Menu("texto");
    }


    @GetMapping("/loadMenu")
    public MenuDTO loadMenu(@RequestParam int id) {
        Menu menu = menuRepository.findMenuById(id);
        MenuDTO menuToReturn = convertToDTO(menu);
        return menuToReturn;
    }

    @GetMapping("/loadMenus")
    public List<MenuDTO> loadMenus() {
        List<Menu> menus = menuRepository.findAll();
        List<MenuDTO> convertedMenus = new ArrayList<>();
        for (Menu menu:menus) {
            convertedMenus.add(convertToDTO(menu));
        }
        return convertedMenus;
    }

    @PostMapping(value = "/createMenu", consumes = "application/json", produces = "application/json")
    public MenuDTO createMenu(@RequestBody MenuDTO newMenu) {
        System.out.println("Se ha recibido un nuevo menu");
        System.out.println(newMenu.toString());
        menuRepository.save(convertToEntity(newMenu));
        return newMenu;
    }

    private Menu convertToEntity(MenuDTO postDto) {
        Menu menu = ConvertUtil.convertDTOtoMenu(postDto);
        return menu;
    }

    @GetMapping("/deleteMenu")
    public void deleteMenu(@RequestAttribute int id) {
        menuRepository.deleteById(id);
    }
        
    private MenuDTO convertToDTO(Menu menu){
        MenuDTO menuDTO = ConvertUtil.convertMenuDTO(menu);
        return menuDTO;
    }
}
