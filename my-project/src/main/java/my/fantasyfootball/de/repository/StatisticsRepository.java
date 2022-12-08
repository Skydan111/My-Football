package my.fantasyfootball.de.repository;

import my.fantasyfootball.de.model.statistics.Statistics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.UUID;

public interface StatisticsRepository extends CrudRepository<Statistics, UUID> {

    @Query("SELECT s FROM Statistics s WHERE s.footballPlayer.id = ?1")
    Statistics[] getFootballPlayerStatistics(UUID footballPlayerId);
}
