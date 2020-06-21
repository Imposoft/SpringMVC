package es.imposoft.SpringMVC.Controller;

import es.imposoft.SpringMVC.Model.Greeting;
import es.imposoft.SpringMVC.Entities.Menu;
import es.imposoft.SpringMVC.Model.MenuModel;
import es.imposoft.SpringMVC.Persistence.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {
    @Autowired // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    private MenuRepository menuRepository;

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    @GetMapping("/testMenu")
    public Menu testMenu() {
        return new Menu("texto");
    }


    @GetMapping("/loadMenu")
    public Menu loadMenu() {
        String menuText = readFileAsString("outputs/testMenu.txt");
        return new Menu(menuText);
    }

    public static String readFileAsString(String fileName) {
        String text = "";
        try {
            text = new String(Files.readAllBytes(Paths.get(fileName)));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return text;
    }

    @PostMapping(value = "/createMenu", consumes = "application/json", produces = "application/json")
    public Menu createMenu(@RequestBody MenuModel newMenu) {
        System.out.println("Se ha creado un menu nuevo " + newMenu.getMenuText());
        Menu menuToSave = new Menu(newMenu.getMenuText());
        menuRepository.save(menuToSave);
        try {
            new File("/outputs").mkdirs();
            PrintWriter writer = new PrintWriter("outputs/testMenu.txt", "UTF-8");
            writer.println(newMenu.getMenuText());
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return menuToSave;
    }
}
