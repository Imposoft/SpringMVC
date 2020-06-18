package es.imposoft.SpringMVC.Controller;

import es.imposoft.SpringMVC.Greeting;
import es.imposoft.SpringMVC.Model.Menu;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@RestController
public class GreetingController {
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

    @PostMapping(value = "/createMenu", consumes = "application/json", produces = "application/json")
    public Menu createMenu(@RequestBody Menu newMenu) {
        System.out.println("Se ha creado un menu nuevo " + newMenu.getMenuText());

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

        return newMenu;
    }
}
