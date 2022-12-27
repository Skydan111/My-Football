package my.fantasyfootball.de.service;

import my.fantasyfootball.de.model.team.Team;
import my.fantasyfootball.de.model.team.TeamModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TeamService {

    List<TeamModel> getAllTeams();
    TeamModel getUserTeam(String userId);
    List<TeamModel> getTeamsByTeamRate();
}
