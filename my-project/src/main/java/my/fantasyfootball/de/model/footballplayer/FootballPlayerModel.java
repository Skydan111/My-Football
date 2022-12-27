package my.fantasyfootball.de.model.footballplayer;

import java.util.UUID;

public class FootballPlayerModel {
    private final UUID uuid;
    private final String fullName;
    private final int price;
    private final Amplua amplua;

    public FootballPlayerModel(FootballPlayer footballPlayer){
        this.uuid = footballPlayer.getId();
        this.fullName = footballPlayer.getFullName();
        this.price = footballPlayer.getPrice();
        this.amplua = footballPlayer.getAmplua();
    }

    public UUID getId() {
        return uuid;
    }

    public String getFullName() {
        return fullName;
    }

    public int getPrice() {
        return price;
    }

    public Amplua getAmplua() {
        return amplua;
    }
}
