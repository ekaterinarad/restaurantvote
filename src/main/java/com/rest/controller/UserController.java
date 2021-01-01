package com.rest.controller;


import com.rest.model.Menu;
import com.rest.model.Vote;
import com.rest.service.MenuService;
import com.rest.service.VoteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    VoteService voteService;

    @Autowired
    MenuService menuService;

    @PostMapping("/vote")
    public Vote vote(Vote vote) {
        return voteService.vote(vote);
    }

    @GetMapping("/all")
    public List<Vote> getAllVotes() {

        logger.info("All votes");
        return voteService.getAllVotes();
    }

   /* @GetMapping("/menus")
    public List<Menu> getAllMenus() {
        return menuService.getAllMenus();
    }*/

    @GetMapping("/menu")
    public List<Menu> getMenuOfToday() {
        return menuService.getMenuOfToday(LocalDate.now());
    }

}
