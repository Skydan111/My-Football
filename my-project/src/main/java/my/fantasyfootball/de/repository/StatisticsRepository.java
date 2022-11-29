package my.fantasyfootball.de.repository;

import my.fantasyfootball.de.model.Statistics;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface StatisticsRepository extends JpaRepository<Statistics, UUID> {
}
