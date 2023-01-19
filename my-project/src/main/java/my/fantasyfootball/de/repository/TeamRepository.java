package my.fantasyfootball.de.repository;

import my.fantasyfootball.de.model.footballplayer.FootballPlayer;
import my.fantasyfootball.de.model.team.Team;
import my.fantasyfootball.de.model.team.TeamModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface TeamRepository extends CrudRepository<Team, UUID> {
    @Query(value = "SELECT s FROM Team s WHERE s.user.id = ?1")
    Team getUserTeam(UUID userId);

    @Query(value = "SELECT s FROM Team s WHERE s.teamName = ?1")
    Team getTeamByTeamName(String teamName);
}
