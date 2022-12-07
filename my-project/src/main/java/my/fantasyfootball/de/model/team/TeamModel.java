package my.fantasyfootball.de.model.team;

import my.fantasyfootball.de.model.team.Team;

public class TeamModel {

    private final String teamName;
    private final Double teamRate;

    public TeamModel(Team team) {
        this.teamName = team.getTeamName();
        this.teamRate = team.getTeamRate();
    }

    public String getTeamName() {
        return teamName;
    }

    public Double getTeamRate() {
        return teamRate;
    }
}
