package com.rest.service;


import com.rest.model.Vote;

import java.util.List;

public interface VoteService {

    Vote vote(Vote vote);

    List<Vote> getAllVotes();
}
