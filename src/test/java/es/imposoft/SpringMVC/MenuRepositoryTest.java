package es.imposoft.SpringMVC;

import com.google.gson.Gson;
import es.imposoft.SpringMVC.Entities.Dish;
import es.imposoft.SpringMVC.Entities.Menu;
import es.imposoft.SpringMVC.Entities.Section;
import es.imposoft.SpringMVC.Model.AllergenModel;
import es.imposoft.SpringMVC.Model.DishModel;
import es.imposoft.SpringMVC.Model.MenuModel;
import es.imposoft.SpringMVC.Model.SectionModel;
import es.imposoft.SpringMVC.Persistence.DishRepository;
import es.imposoft.SpringMVC.Persistence.MenuRepository;
import es.imposoft.SpringMVC.Persistence.SectionRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MenuRepositoryTest {
    @Autowired
    private MenuRepository menuRepository;
    @Autowired
    private SectionRepository sectionRepository;
    @Autowired
    private DishRepository dishRepository;

    @Before
    public void setUp() throws Exception {
        List<AllergenModel> allergensList = new ArrayList<>();
        allergensList.add(AllergenModel.APIO);
        allergensList.add(AllergenModel.ALTRAMUCES);
        Dish dish1 = new Dish("Bravas","Picaan bro",allergensList,20.4);
        Dish dish2 = new Dish("Morro de cerdo","Bro que rico",allergensList,4.5);
        List<Dish> dishes = new ArrayList<>();
        dishes.add(dish1);
        Section section1 = new Section("seccion 1","descripcion de secion",dishes);
        dishes.add(dish2);
        Section section2 = new Section("seccion 2","descripcion de secion",dishes);
        List<Section> sections = new ArrayList<>();
        sections.add(section1);
        sections.add(section2);
        Menu menu1 = new Menu("TestMenuNew1","testDescription123",sections);
        assertEquals(0,menu1.getId());

        this.menuRepository.save(menu1);

        assertNotNull(menu1.getId());
    }

    /*@Test
    public void testFetchData() {
        /*Test data retrieval
        Menu menu1 = menuRepository.findFirstByName("TestMenuNew1");
        assertNotNull(menu1);
        System.out.println(menu1.getId());
        assertEquals("TestMenuNew1", menu1.getName());
    }*/

    @Test
    public void testMenuJSON(){
        /*Gson gson = new Gson();
        List<AllergenModel> allergensList = new ArrayList<>();
        allergensList.add(AllergenModel.APIO);
        allergensList.add(AllergenModel.ALTRAMUCES);
        DishModel dish1 = new DishModel(0,"Nombre", "Descripcion",allergensList,24.0,null);
        DishModel dish2 = new DishModel(1,"Nombre2", "Descripcion2",allergensList,25.0,null);
        List<DishModel> dishes1 = new ArrayList<DishModel>();
        List<DishModel> dishes2 = new ArrayList<DishModel>();
        dishes1.add(dish1);
        dishes2.add(dish2);
        SectionModel section1 = new SectionModel(0,"Section1","Description1",dishes1);
        SectionModel section2 = new SectionModel(2,"Section1","Description1",dishes2);
        List<SectionModel> sections = new ArrayList<>();
        sections.add(section1);
        sections.add(section2);
        MenuModel menu = new MenuModel(sections,"Nombre menu","Descripcion menu", 0);
        System.out.println(gson.toJson(menu));*/
    }
}