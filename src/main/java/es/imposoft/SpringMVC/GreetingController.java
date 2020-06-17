package es.imposoft.SpringMVC;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

@Controller
public class GreetingController {

    @GetMapping(value = "/write")
    public ResponseEntity<String> write(
            @RequestParam(name="name", required=false, defaultValue="World") String name,
            @RequestParam(name="msg", required=false, defaultValue="World") int msg
            //Model model
    ) {
       // model.addAttribute("name", name);
        //return ResponseEntity.ok(name);

        try (FileOutputStream inputStream = new FileOutputStream(name)) {
            inputStream.write(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return ResponseEntity.ok(
                msg + " escrito"
        );
    }

    @GetMapping(value = "/read")
    public ResponseEntity<String> read(
            @RequestParam(name="name", required=false, defaultValue="World") String name
            //Model model
    ) {
       // model.addAttribute("name", name);
        //return ResponseEntity.ok(name);

        return null;
    }

}
