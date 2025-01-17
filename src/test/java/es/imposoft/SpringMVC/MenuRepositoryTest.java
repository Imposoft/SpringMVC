package es.imposoft.SpringMVC;

import es.imposoft.SpringMVC.Entities.Dish;
import es.imposoft.SpringMVC.Entities.Menu;
import es.imposoft.SpringMVC.Entities.Section;
import es.imposoft.SpringMVC.Logic.Converter.ConvertUtil;
import es.imposoft.SpringMVC.Models.AllergenDTO;
import es.imposoft.SpringMVC.Models.DishDTO;
import es.imposoft.SpringMVC.Models.MenuDTO;
import es.imposoft.SpringMVC.Models.SectionDTO;
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
        List<AllergenDTO> allergensList = new ArrayList<>();
        allergensList.add(AllergenDTO.APIO);
        allergensList.add(AllergenDTO.ALTRAMUCES);
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

        //this.menuRepository.save(menu1);

        assertNotNull(menu1.getId());
    }

    @Test
    public void testFetchData() {
        //Test data retrieval
        Menu menu1 = menuRepository.findMenuById(1);
        menu1.setDescription("Nueva descripcion");
        MenuDTO menuDTO = ConvertUtil.convertMenuDTO(menu1);
        assertNotNull(menu1);
        assertNotNull(menuDTO);
        menuRepository.save(menu1);
        System.out.println(menu1.getId() + menu1.getMenuText());
        System.out.println(menuDTO.getId() + menuDTO.getName());
        assertEquals("TestMenuNew1", menu1.getName());
    }

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

    @Test
    public void testDTOConversion(){
        List<AllergenDTO> allergensList = new ArrayList<>();
        allergensList.add(AllergenDTO.APIO);
        DishDTO dish = new DishDTO(0,"Bravas","pican bro",allergensList,23.0);
        List<DishDTO> dishes = new ArrayList<>();
        dishes.add(dish);
        SectionDTO section = new SectionDTO(0,"seccion 1","descripcion de secion",dishes);
        List<SectionDTO> sections = new ArrayList<>();
        sections.add(section);
        MenuDTO postDto = new MenuDTO(sections,"Nombre","descripcion",0);
        Menu menu = ConvertUtil.convertDTOtoMenu(postDto);

        assertEquals("Bravas",menu.getSections().get(0).getDishes().get(0).getName());
        assertEquals("seccion 1",menu.getSections().get(0).getName());
        assertEquals("Nombre",menu.getName());
    }

    @Test
    public void testEntityConversion(){
        Menu menu = menuRepository.findMenuById(1);
        System.out.println(menu.getSections().get(0).getName());
        assertEquals("tESTmenu", menu.getName());
    }
}