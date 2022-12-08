package my.fantasyfootball.de.controller;

import my.fantasyfootball.de.model.statistics.StatisticsModel;
import my.fantasyfootball.de.service.StatisticsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/players/statistics")
public class StatisticsController {
    private final StatisticsService statisticsService;

    public StatisticsController(StatisticsService statisticsService) {
        this.statisticsService = statisticsService;
    }

    @GetMapping(path = "/{footballPlayerId}")
    public List<StatisticsModel> getFootballPlayerStatistics(@PathVariable String footballPlayerId){
        return statisticsService.getFootballPlayerStatistics(footballPlayerId);
    }
}
