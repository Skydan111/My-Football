package my.fantasyfootball.de.model.footballplayer;

public class FootballPlayerModel {
    private final String firstName;
    private final String lastName;

    public FootballPlayerModel(FootballPlayer footballPlayer){
        this.firstName = footballPlayer.getFirstName();
        this.lastName = footballPlayer.getLastName();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
