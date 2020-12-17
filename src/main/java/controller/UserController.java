package controller;

import model.Vote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.VoteService;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    VoteService voteService;

    @PostMapping("/vote")
    public Vote vote(Vote vote) {
        return voteService.vote(vote);
    }

    @GetMapping("/all")
    public List<Vote> getAllVotes() {
        return voteService.getAllVotes();
    }
}
