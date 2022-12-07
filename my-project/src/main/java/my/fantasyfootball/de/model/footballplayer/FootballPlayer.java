package my.fantasyfootball.de.model.footballplayer;


import my.fantasyfootball.de.model.Statistics;
import my.fantasyfootball.de.model.team.Team;

import javax.persistence.*;
import java.util.*;

@Entity(name = "FootballPlayer")
@Table(name = "football_players")
public class FootballPlayer {

    @Id
    @GeneratedValue
    @Column(
            name = "id",
            nullable = false,
            updatable = false
    )
    private UUID id;

    @Column(
            name = "first_name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String firstName;

    @Column(
            name = "last_name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String lastName;

    @Column(
            name = "nationality",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String nationality;

    @Enumerated(EnumType.STRING)
    @Column(
            name = "amplua",
            nullable = false
    )
    private Amplua amplua;

    @Column(
            name = "price",
            nullable = false,
            columnDefinition = "INTEGER"
    )
    private int price;

    @Transient
    private double footballPlayerRate;

    @ManyToMany(
            mappedBy = "squad",
            fetch = FetchType.LAZY
    )
    private final Set<Team> teams = new HashSet<>();

    @OneToMany(
            mappedBy = "footballPlayer",
            orphanRemoval = true,
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE}
    )
    private final List<Statistics> statisticsList = new ArrayList<>();

    public FootballPlayer() {
    }

    public FootballPlayer(String firstName, String lastName, String nationality, Amplua amplua, int price) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.nationality = nationality;
        this.amplua = amplua;
        this.price = price;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public Amplua getAmplua() {
        return amplua;
    }

    public void setAmplua(Amplua amplua) {
        this.amplua = amplua;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public double getFootballPlayerRate() {
        double sum = 0;
        for(Statistics stat : statisticsList) {
            sum = sum + stat.getRatingPerGame();
        }
        return sum  / statisticsList.size();
    }

    public Set<Team> getTeams() {
        return teams;
    }

    public List<Statistics> getStatisticsList() {
        return statisticsList;
    }

    public void addStatistics(Statistics statistics) {
            this.statisticsList.add(statistics);
            statistics.setFootballPlayer(this);
    }

    public void removeStatistics(Statistics statistics) {
            this.statisticsList.remove(statistics);
            statistics.setFootballPlayer(null);
    }

    @Override
    public String toString() {
        return "FootballPlayer{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", nationality='" + nationality + '\'' +
                ", amplua=" + amplua +
                ", price=" + price +
                ", footballPlayerRate=" + footballPlayerRate +
                '}';
    }
}
