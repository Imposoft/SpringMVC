package es.imposoft.SpringMVC;

import es.imposoft.SpringMVC.Entities.Dish;
import es.imposoft.SpringMVC.Entities.Menu;
import es.imposoft.SpringMVC.Entities.Section;
import es.imposoft.SpringMVC.Model.AllergenModel;
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
        Menu menu2 = new Menu("TestMenuNew2","testDescription1234");
        Section section2 = new Section("seccion 2","descripcion de secion2",menu2);
        Menu menu1 = new Menu("TestMenuNew1","testDescription123");
        Section section1 = new Section("seccion 1","descripcion de secion",menu1);
        List<AllergenModel> allergensList = new ArrayList<>();
        allergensList.add(AllergenModel.APIO);
        allergensList.add(AllergenModel.ALTRAMUCES);
        List<Section> sections = new ArrayList<>();
        sections.add(section1);
        sections.add(section2);
        Dish dish1 = new Dish("Bravas","Picaan bro",allergensList,20.4,sections);
        this.dishRepository.save(dish1);
        assertEquals(0,menu1.getId());
        //this.menuRepository.save(menu1);
        assertNotNull(menu1.getId());
    }

    @Test
    public void testFetchData() {
        /*Test data retrieval*/
        Menu menu1 = menuRepository.findFirstByName("TestMenuNew1");
        assertNotNull(menu1);
        System.out.println(menu1.getId());
        assertEquals("TestMenuNew1", menu1.getName());
    }
}