package my.fantasyfootball.de.controller;

import my.fantasyfootball.de.model.team.Team;
import my.fantasyfootball.de.model.team.TeamModel;
import my.fantasyfootball.de.service.TeamService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/teams")
public class TeamController {

    private final TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping
    public List<TeamModel> getTeams(){
        return teamService.getAllTeams();
    }

    @GetMapping(path = "/{userId}")
    public TeamModel getUserTeam(@PathVariable String userId){
        return teamService.getUserTeam(userId);
    }
}
