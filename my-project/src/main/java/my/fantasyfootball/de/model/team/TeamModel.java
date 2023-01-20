package my.fantasyfootball.de.model.team;

import my.fantasyfootball.de.model.team.Team;

public class TeamModel {

    private final String teamName;
    private final String teamRate;

    public TeamModel(Team team) {
        this.teamName = team.getTeamName();
        this.teamRate = team.getTeamRate();
    }

    public String getTeamName() {
        return teamName;
    }

    public String getTeamRate() {
        return teamRate;
    }
}
