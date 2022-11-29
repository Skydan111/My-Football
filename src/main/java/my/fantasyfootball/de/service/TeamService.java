package my.fantasyfootball.de.service;

import my.fantasyfootball.de.model.Team;

import java.util.List;

public interface TeamService {

    List<Team> getAllTeams();
    Team getUserTeam(String userId);
}
