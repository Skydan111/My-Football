package my.fantasyfootball.de.service;

import my.fantasyfootball.de.model.statistics.StatisticsModel;

import java.util.List;

public interface StatisticsService {
    List<StatisticsModel> getFootballPlayerStatistics(String footballPlayerUserId);
}
