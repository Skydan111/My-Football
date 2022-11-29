package my.fantasyfootball.de.controller;

import my.fantasyfootball.de.model.Team;
import my.fantasyfootball.de.model.TeamModel;
import my.fantasyfootball.de.model.User;
import my.fantasyfootball.de.service.TeamService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
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
//        User oleg = new User(
//                "oskidan8684@gmail.com",
//                "Oleg",
//                "Skydan",
//                "123456789");
//
//        User nick = new User(
//                "nick.skydan@gmail.com",
//                "Nick",
//                "Skydan",
//                "987654321");
//
//        Team everton = new Team("Everton", oleg);
//        Team arsenal = new Team("Arsenal", nick);

        List<Team> teams = teamService.getAllTeams();

        List<TeamModel> teamModels = new ArrayList<>();

        for(Team team : teams){
            TeamModel teamModel = new TeamModel(team);
            teamModels.add(teamModel);
        }

        return teamModels;
    }

    @GetMapping(path = "/{userId}")
    public TeamModel getUserTeam(@PathVariable String userId){
        Team team = teamService.getUserTeam(userId);
        return new TeamModel(team);
    }
}
