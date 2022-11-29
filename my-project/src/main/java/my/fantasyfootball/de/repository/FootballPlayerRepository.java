package my.fantasyfootball.de.repository;

import my.fantasyfootball.de.model.footballplayer.FootballPlayer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FootballPlayerRepository extends JpaRepository<FootballPlayer, UUID> {
}
