package es.imposoft.SpringMVC.Persistence;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class WebsiteRepository {
    public static void saveTextAsFileWithFilename(Object objectToSave,String fileName){
        try {
            new File("/outputs").mkdirs();
            PrintWriter writer = new PrintWriter("outputs/" + fileName + ".txt", "UTF-8");
            writer.println(objectToSave.toString());
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

}
