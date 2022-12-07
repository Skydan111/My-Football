package my.fantasyfootball.de.service.impl;

import my.fantasyfootball.de.model.team.Team;
import my.fantasyfootball.de.model.team.TeamModel;
import my.fantasyfootball.de.repository.TeamRepository;
import my.fantasyfootball.de.service.TeamService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class TeamServiceImpl implements TeamService {

    private final TeamRepository teamRepository;

    public TeamServiceImpl(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @Override
    public List<TeamModel> getAllTeams() {

        List<Team> teams = (List<Team>) teamRepository.findAll();

        List<TeamModel> teamModels = new ArrayList<>();

        for(Team team : teams){
            TeamModel teamModel = new TeamModel(team);
            teamModels.add(teamModel);
        }
        return teamModels;
    }

    public TeamModel getUserTeam(String userId) {
        UUID id = UUID.fromString(userId);
        Team team = teamRepository.getUserTeam(id);
        TeamModel teamModel = new TeamModel(team);
        return teamModel;
    }
}
