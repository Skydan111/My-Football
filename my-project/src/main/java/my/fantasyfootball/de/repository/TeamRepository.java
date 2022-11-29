package my.fantasyfootball.de.repository;

import my.fantasyfootball.de.model.Team;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface TeamRepository extends CrudRepository<Team, UUID> {
}
