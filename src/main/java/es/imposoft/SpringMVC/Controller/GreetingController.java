package es.imposoft.SpringMVC.Controller;

import es.imposoft.SpringMVC.Logic.Converter.ConvertUtil;
import es.imposoft.SpringMVC.Model.Greeting;
import es.imposoft.SpringMVC.Entities.Menu;
import es.imposoft.SpringMVC.Model.MenuDTO;
import es.imposoft.SpringMVC.Persistence.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {
    @Autowired
    private MenuRepository menuRepository;

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    @GetMapping("/loadMenu")
    public MenuDTO loadMenu(@RequestParam int id) {
        Menu menu = menuRepository.findMenuById(id);
        MenuDTO menuToReturn = convertToDTO(menu);
        return menuToReturn;
    }

    @PostMapping(value = "/createMenu", consumes = "application/json", produces = "application/json")
    public MenuDTO createMenu(@RequestBody MenuDTO newMenu) {
        System.out.println("Se ha recibido un nuevo menu");
        System.out.println(newMenu.toString());
        menuRepository.save(convertToEntity(newMenu));
        return newMenu;
    }

    private Menu convertToEntity(MenuDTO postDto) {
        Menu menu = ConvertUtil.convertMenu(postDto);
        return menu;
    }

    private MenuDTO convertToDTO(Menu menu){
        MenuDTO menuDTO = ConvertUtil.convertMenuDTO(menu);
        return menuDTO;
    }
}
