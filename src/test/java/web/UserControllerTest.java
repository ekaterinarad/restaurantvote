package web;

import com.google.gson.Gson;
import com.restaurantvoting.model.Vote;
import org.slf4j.Logger;
import org.junit.jupiter.api.Test;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static data.UserTestData.USER;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static util.TestUtil.userAuth;

public class UserControllerTest extends AbstractControllerTest {

    private final Logger logger = LoggerFactory.getLogger(AdminControllerTest.class);

    @Test
    void getTodaysMenu() throws Exception {
        perform(get("/user/menu")
                .with(userAuth(USER)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
        logger.info("get user");
    }

    @Test
    void getMyVotesHistory() throws Exception {
        perform(get("/user/votes-history")
                .with(userAuth(USER)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }

    @Test
    void testGetUnauthorized() throws Exception {
        perform(get("/user/menu"))
                .andExpect(status().isUnauthorized());
    }

    @Test
    void testVote() throws Exception {
        Vote vote = new Vote();
        int rest_id = 100000;
        vote.setRest_id(rest_id);
        Gson gson = new Gson();
        String s = gson.toJson(vote);
        perform(post("/user/vote").contentType(MediaType.APPLICATION_JSON)
                .content(s).with(userAuth(USER)))
                .andExpect(status().isOk())
        .andExpect(jsonPath("$.username").value(USER.getName()))
        .andExpect(jsonPath("$.rest_id").value(rest_id));
        logger.info("post restaurant {}", rest_id);
    }


}
