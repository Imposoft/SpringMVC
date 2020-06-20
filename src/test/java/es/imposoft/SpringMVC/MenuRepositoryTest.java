package es.imposoft.SpringMVC;

import es.imposoft.SpringMVC.Entities.Menu;
import es.imposoft.SpringMVC.Persistence.MenuRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MenuRepositoryTest {
    @Autowired
    private MenuRepository menuRepository;

    @Before
    public void setUp() throws Exception {
        Menu menu1 = new Menu("test123");
        //save user, verify has ID value after save
        assertEquals(0,menu1.getId());
        this.menuRepository.save(menu1);
        assertNotNull(menu1.getId());
    }

    @Test
    public void testFetchData() {
        /*Test data retrieval*/
        Menu menu1 = menuRepository.findMenuByMenuText("test123");
        assertNotNull(menu1);
        assertEquals("test123", menu1.getMenuText());
        /*Get all products, list should only have two*/
        Iterable<Menu> menus = menuRepository.findAll();
        int count = 0;
        for (Menu m : menus) {
            count++;
        }
        assertEquals(count, 1);
    }
}