package web;

import com.rest.model.User;
import org.junit.jupiter.api.Test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static web.TestUtil.userAuth;

public class UserTest extends AbstractControllerTest{

    public static final User USER = new User("user", "test1");

    @Test
    void getUsers() throws Exception {
        perform(get("/user/all")
                .with(userAuth(USER)))
                .andDo(print())
                .andExpect(status().isOk());
    }


}
