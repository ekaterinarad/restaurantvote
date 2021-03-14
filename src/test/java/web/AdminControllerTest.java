package web;

import com.google.gson.Gson;
import com.restaurantvoting.model.Dish;
import com.restaurantvoting.model.Menu;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;

import java.util.ArrayList;
import java.util.List;

import static data.UserTestData.ADMIN;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static util.TestUtil.userAuth;

public class AdminControllerTest extends AbstractControllerTest {

    private final Logger logger = LoggerFactory.getLogger(AdminControllerTest.class);

    @Test
    public void addNewMenu() throws Exception {
        Menu menu = new Menu();
        menu.setName("test menu");
        List<Dish> dishes = new ArrayList<>();
        Dish dish1 = new Dish();
        dish1.setName("test dish");
        dish1.setPrice(450);
        menu.setDishes(dishes);
        Gson gson = new Gson();
        String body = gson.toJson(menu);
        perform(post("/admin/menus")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(body)
                .with(userAuth(ADMIN)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("test menu"));
        logger.info("added new test menu");

    }

    @Test
    public void getMenus() throws Exception {
        perform(get("/admin/menus")
                .with(userAuth(ADMIN)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
        logger.info("menus are listed");
    }

    @Test
    public void deleteMenu() throws Exception {
        perform(delete("/admin/menus/100000")
                .with(userAuth(ADMIN)))
                .andExpect(status().isOk());
        logger.info("menu deleted");
    }
}





















