package my.fantasyfootball.de.model.team;


import my.fantasyfootball.de.model.User;
import my.fantasyfootball.de.model.footballplayer.FootballPlayer;

import javax.persistence.*;
import java.text.DecimalFormat;
import java.util.*;

@Entity(name = "Team")
@Table(name = "teams")
public class Team {
    @Id
    @GeneratedValue
    @Column(
            name = "id",
            nullable = false,
            updatable = false
    )
    private UUID id;

    @Column(
            name = "team_name",
            nullable = false,
            length = 50
    )
    private String teamName;

    @Column(
            name = "schema",
            nullable = false,
            length = 15
    )
    private String schema;

    @Column(
            name = "budget",
            nullable = false
    )
    private Long budget = 200_000_000L;

    @Transient
    private double teamRate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "user_id",
            nullable = false,
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "team_user_id_fk"
            )
    )
    private User user;

    @ManyToMany(
            fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE}
    )
    @JoinTable(
            name = "transfer",
            joinColumns = {
                    @JoinColumn(
                    name = "team_id",
                    foreignKey = @ForeignKey(
                            name = "transfer_team_id_fk"
                    )
            )},
            inverseJoinColumns = @JoinColumn(
                    name = "football_player_id",
                    foreignKey = @ForeignKey(
                            name = "transfer_football_player_id_fk"
            )
        )
    )
    private final List<FootballPlayer> squad = new ArrayList<>();

    public Team() {
    }

    public Team(String teamName) {
        this.teamName = teamName;
    }

    public Team(String teamName, User user) {
        this.teamName = teamName;
        this.user = user;
    }

    public Team(String teamName, String schema, User user) {
        this.teamName = teamName;
        this.schema = schema;
        this.user = user;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getTeamRate() {
        String formatDouble = String.valueOf(new DecimalFormat("#0.00"));
        double sum = 0;
        for(FootballPlayer player : squad){
            sum = sum + player.getFootballPlayerRate();
        }
        return new DecimalFormat("#0.00").format(sum / squad.size());
    }

    public String getSchema() {
        return schema;
    }

    public void setSchema(String schema) {
        this.schema = schema;
    }

    public Long getBudget() {
        return budget;
    }

    public void setBudget(Long budget) {
        this.budget = budget;
    }

    public List<FootballPlayer> getSquad() {
        return squad;
    }

    public void transferToSquad(FootballPlayer player){
        squad.add(player);
        player.getTeams().add(this);
    }

    public void removeFromSquad(FootballPlayer player){
        squad.remove(player);
        player.getTeams().remove(this);
    }

    @Override
    public String toString() {
        return "Team{" +
                "teamName='" + teamName + '\'' +
                ", schema='" + schema + '\'' +
                '}';
    }
}
