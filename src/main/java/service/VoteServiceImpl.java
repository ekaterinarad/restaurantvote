package service;

import exceptions.AlreadyVotedException;
import model.Vote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import repository.IVoteRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.*;

@Service
public class VoteServiceImpl implements VoteService {

    @Autowired
    IVoteRepository repository;

    @Override
    public Vote vote(Vote vote) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();

        Vote v = new Vote();
        v.setUsername(currentPrincipalName);
        v.setDate(LocalDate.now());

        ExampleMatcher matcher = ExampleMatcher.matching()
                .withIgnorePaths("id")
                .withMatcher("username", ignoreCase())
                .withMatcher("date", ignoreCase());

        Example<Vote> example = Example.of(v,matcher);
        boolean exists = repository.exists(example);

        if (exists && LocalTime.now().isBefore(LocalTime.of(11, 0))) {
            repository.delete(repository.findOne(example).get());
        } else if (exists && LocalTime.now().isAfter(LocalTime.of(11, 0))) {
            throw new AlreadyVotedException();
        }
        vote.setDate(LocalDate.now());
        vote.setTime(LocalTime.now());
        vote.setUsername(currentPrincipalName);
        repository.saveAndFlush(vote);
        return vote;
    }

    @Override
    public List<Vote> getAllVotes() {
        return repository.findAll();
    }
}
