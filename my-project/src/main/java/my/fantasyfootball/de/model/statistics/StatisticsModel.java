package my.fantasyfootball.de.model.statistics;

public class StatisticsModel {
    private final String opponentTeam;
    private final int goals;
    private final int assists;
    private final int ratingPerGame;

    public StatisticsModel(Statistics statistics) {
        this.opponentTeam = statistics.getOpponentTeam();
        this.goals = statistics.getGoals();
        this.assists = statistics.getAssists();
        this.ratingPerGame = statistics.getRatingPerGame();
    }

    public String getOpponentTeam() {
        return opponentTeam;
    }

    public int getGoals() {
        return goals;
    }

    public int getAssists() {
        return assists;
    }

    public int getRatingPerGame() {
        return ratingPerGame;
    }
}
