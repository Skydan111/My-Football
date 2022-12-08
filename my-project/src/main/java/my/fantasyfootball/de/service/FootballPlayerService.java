package my.fantasyfootball.de.service;

import my.fantasyfootball.de.model.footballplayer.FootballPlayer;
import my.fantasyfootball.de.model.footballplayer.FootballPlayerModel;

import java.util.List;

public interface FootballPlayerService {
    List<FootballPlayerModel> getAllFootballPlayers();
}
