package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.VoteService;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    VoteService voteService;


}
