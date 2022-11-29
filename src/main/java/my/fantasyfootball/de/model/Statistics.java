package my.fantasyfootball.de.model;

import my.fantasyfootball.de.model.footballplayer.FootballPlayer;

import javax.persistence.*;

import java.util.UUID;

@Entity(name = "Statistics")
@Table(name = "statistics")
public class Statistics {

    @Id
    @GeneratedValue
    @Column(
            name = "id",
            nullable = false,
            updatable = false
    )
    private UUID id;

    @Column(
            name = "opponentTeam",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String opponentTeam;

    @Column(
            name = "goals",
            nullable = false,
            columnDefinition = "INTEGER"
    )
    private int goals;

    @Column(
            name = "assists",
            nullable = false,
            columnDefinition = "INTEGER"
    )
    private int assists;

    @Column(
            name = "rating_per_game",
            nullable = false,
            columnDefinition = "INTEGER"
    )
    private int ratingPerGame;

    @ManyToOne
    @JoinColumn(
            name = "football_player_id",
            nullable = false,
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "statistics_football_player_id_fk"
            )
    )
    private FootballPlayer footballPlayer;

    public Statistics() {
    }

    public Statistics(String opponentTeam, int goals, int assists, int ratingPerGame) {
        this.opponentTeam = opponentTeam;
        this.goals = goals;
        this.assists = assists;
        this.ratingPerGame = ratingPerGame;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getOpponentTeam() {
        return opponentTeam;
    }

    public void setOpponentTeam(String opponentTeam) {
        this.opponentTeam = opponentTeam;
    }

    public int getGoals() {
        return goals;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }

    public int getAssists() {
        return assists;
    }

    public void setAssists(int assists) {
        this.assists = assists;
    }

    public double getRatingPerGame() {
        return ratingPerGame;
    }

    public void setRatingPerGame(int ratingPerGame) {
        this.ratingPerGame = ratingPerGame;
    }

    public void setFootballPlayer(FootballPlayer footballPlayer) {
        this.footballPlayer = footballPlayer;
    }
}
