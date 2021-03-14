package com.rest.repository;


import com.rest.model.Vote;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IVoteRepository extends JpaRepository<Vote, Integer> {
    List<Vote> findAllByUsername(String name);
}
