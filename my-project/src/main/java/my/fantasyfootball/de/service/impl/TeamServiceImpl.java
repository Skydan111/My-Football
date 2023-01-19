package my.fantasyfootball.de.service.impl;

import my.fantasyfootball.de.model.footballplayer.FootballPlayer;
import my.fantasyfootball.de.model.footballplayer.FootballPlayerModel;
import my.fantasyfootball.de.model.team.Team;
import my.fantasyfootball.de.model.team.TeamModel;
import my.fantasyfootball.de.repository.TeamRepository;
import my.fantasyfootball.de.service.TeamService;
import org.springframework.stereotype.Service;

import java.util.*;

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

    @Override
    public List<TeamModel> getTeamsByTeamRate() {

        List<TeamModel> teamModels = getAllTeams();

        Collections.reverse(teamModels);

        return teamModels;
    }

    @Override
    public List<FootballPlayerModel> getTeamSquad(String teamName) {
        Team team = teamRepository.getTeamByTeamName(teamName);
        List<FootballPlayer> squad = team.getSquad();
        List<FootballPlayerModel> teamSquad = new ArrayList<>();
        for(FootballPlayer player : squad) {
            FootballPlayerModel footballPlayerModel = new FootballPlayerModel(player);
            teamSquad.add(footballPlayerModel);
        }

        return teamSquad;
    }

}
