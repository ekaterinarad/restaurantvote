package com.restaurantvoting.service;


import com.restaurantvoting.model.Vote;

import java.util.List;

public interface VoteService {

    Vote vote(Vote vote);

    List<Vote> getAllVotes(String name);
}
