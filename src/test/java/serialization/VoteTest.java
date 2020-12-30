package serialization;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.rest.model.Vote;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.containsString;

@DisplayNameGeneration(DisplayNameGenerator.Simple.class)
public class VoteTest {
    @Test
    @DisplayName("JSON test")
    public void testVote() throws JsonProcessingException {
        Vote vote = new Vote();
        vote.setUsername("user");
        vote.setTime(LocalTime.now());
        vote.setDate(LocalDate.now());
        vote.setId(1);
        vote.setRest_id(123);

        String resultJson = new ObjectMapper().registerModule(new JavaTimeModule()).writeValueAsString(vote);

        System.out.println(resultJson);

        assertThat(resultJson, containsString("username"));
        assertThat(resultJson, containsString("id"));
    }

    @Test
    public void authorizeTest() throws JsonProcessingException {

    }
}
