package web;

import com.rest.model.User;
import org.junit.jupiter.api.Test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static web.TestData.USER;
import static web.TestUtil.userAuth;

public class UserTest extends AbstractControllerTest{

    @Test
    void getUsers() throws Exception {
        perform(get("/user/all")
                .with(userAuth(USER)))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void checkMyVotesHistory() throws Exception {
        perform(get("/user/votes-history")
                .with(userAuth(USER)))
                .andDo(print())
                .andExpect(status().isOk());
              //  .andExpect()
    }


}
