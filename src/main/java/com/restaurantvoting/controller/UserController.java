package com.restaurantvoting.controller;


import com.restaurantvoting.model.Menu;
import com.restaurantvoting.model.Vote;
import com.restaurantvoting.service.MenuService;
import com.restaurantvoting.service.VoteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private static final LocalTime EXPIRED_TIME = LocalTime.parse("11:00");

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    VoteService voteService;

    @Autowired
    MenuService menuService;

    @PostMapping("/vote")
    public Vote vote(@RequestBody Vote vote) {
        return voteService.vote(vote);
    }

    @GetMapping("/votes-history")
    public List<Vote> getAllVotes(Principal principal) {

        logger.info("This user votes");
        return voteService.getAllVotes(principal.getName());
    }

    @GetMapping("/menu")
    public List<Menu> getMenuOfToday() {
        return menuService.getMenuOfToday(LocalDate.now());
    }

}
