package repository;

import model.Vote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IVoteRepository extends JpaRepository<Vote, Integer> {
}
