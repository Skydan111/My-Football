package my.fantasyfootball.de.service.impl;

import my.fantasyfootball.de.model.footballplayer.FootballPlayer;
import my.fantasyfootball.de.model.footballplayer.FootballPlayerModel;
import my.fantasyfootball.de.repository.FootballPlayerRepository;
import my.fantasyfootball.de.service.FootballPlayerService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FootballPlayerServiceImpl implements FootballPlayerService {
    private final FootballPlayerRepository footballPlayerRepository;

    public FootballPlayerServiceImpl(FootballPlayerRepository footballPlayerRepository) {
        this.footballPlayerRepository = footballPlayerRepository;
    }

    @Override
    public List<FootballPlayerModel> getAllFootballPlayers() {
        List<FootballPlayer> players = footballPlayerRepository.findAll();
        List<FootballPlayerModel> playerModels = new ArrayList<>();
        for(FootballPlayer player : players) {
            FootballPlayerModel footballPlayerModel = new FootballPlayerModel(player);
            playerModels.add(footballPlayerModel);
        }
        return playerModels;
    }
}
