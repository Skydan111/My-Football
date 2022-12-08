package my.fantasyfootball.de.controller;

import my.fantasyfootball.de.model.footballplayer.FootballPlayerModel;
import my.fantasyfootball.de.service.FootballPlayerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path =  "api/v1/players")
public class FootballPlayerController {
    private final FootballPlayerService playerService;

    public FootballPlayerController(FootballPlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping
    public List<FootballPlayerModel> playerModels(){
        return playerService.getAllFootballPlayers();
    }
}
