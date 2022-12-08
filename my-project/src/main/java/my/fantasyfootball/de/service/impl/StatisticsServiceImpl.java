package my.fantasyfootball.de.service.impl;

import my.fantasyfootball.de.model.statistics.Statistics;
import my.fantasyfootball.de.model.statistics.StatisticsModel;
import my.fantasyfootball.de.repository.StatisticsRepository;
import my.fantasyfootball.de.service.StatisticsService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class StatisticsServiceImpl implements StatisticsService {
    private final StatisticsRepository statisticsRepository;

    public StatisticsServiceImpl(StatisticsRepository statisticsRepository) {
        this.statisticsRepository = statisticsRepository;
    }

    @Override
    public List<StatisticsModel> getFootballPlayerStatistics(String footballPlayerUserId) {
        UUID uuid = UUID.fromString(footballPlayerUserId);
        Statistics[] statistics = statisticsRepository.getFootballPlayerStatistics(uuid);
        List<StatisticsModel> stat = new ArrayList<>();
        for(Statistics statistic : statistics) {
            StatisticsModel statisticsModel = new StatisticsModel(statistic);
            stat.add(statisticsModel);
        }
        return stat;
    }
}
