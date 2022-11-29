package my.fantasyfootball.de.model;

public class TeamModel {

    private final String teamName;

    public TeamModel(Team team) {
        this.teamName = team.getTeamName();
    }

    public String getTeamName() {
        return teamName;
    }


}
