package my.fantasyfootball.de;

import my.fantasyfootball.de.model.*;
import my.fantasyfootball.de.model.footballplayer.Amplua;
import my.fantasyfootball.de.model.footballplayer.FootballPlayer;
import my.fantasyfootball.de.model.team.Team;
import my.fantasyfootball.de.repository.TeamRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;


@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(TeamRepository teamRepository) {

		return args -> {
					User oleg = new User(
							"oskidan8684@gmail.com",
							"Oleg",
							"Skydan",
							"123456789");

					User nick = new User(
							"nick.skydan@gmail.com",
							"Nick",
							"Skydan",
							"987654321");

					User kate = new User(
							"katucik_14@gmail.com",
							"Kate",
							"Skydan",
							"Kate2512");

			Team everton = new Team("Everton","4-4-2", oleg);
			oleg.setTeam(everton);

			Team arsenal = new Team("Arsenal","4-5-1", nick);
			nick.setTeam(arsenal);

			Team city = new Team("Manchester City","4-2-3-1", kate);
			kate.setTeam(city);

			FootballPlayer mykolenko = new FootballPlayer(
					"Vitaliy",
					"Mykolenko",
					"Ukraine",
					Amplua.DEFENDER,
					30_000_000);

			FootballPlayer garner = new FootballPlayer(
					"James",
					"Garner",
					"England",
					Amplua.MIDFIELDER,
					10_000_000);

			FootballPlayer gueye = new FootballPlayer(
					"Idrissa",
					"Gueye",
					"Senegal",
					Amplua.MIDFIELDER,
					40_000_000);

			FootballPlayer holland = new FootballPlayer(
					"Erling",
					"Holland",
					"Norway",
					Amplua.FORWARD,
					120_000_000);

			mykolenko.addStatistics(new Statistics("MU", 0, 0, 8));
			mykolenko.addStatistics(new Statistics("MC", 0, 0, 6));
			mykolenko.addStatistics(new Statistics("Chelsey", 0, 1, 7));

			garner.addStatistics(new Statistics("MU", 1, 0, 7));
			garner.addStatistics(new Statistics("MC", 0, 1, 8));
			garner.addStatistics(new Statistics("Chelsey", 0, 0, 5));

			gueye.addStatistics(new Statistics("MU", 1, 0, 8));
			gueye.addStatistics(new Statistics("MC", 1, 0, 7));
			gueye.addStatistics(new Statistics("Chelsey", 0, 1, 7));

			holland.addStatistics(new Statistics("MU", 3, 0, 9));
			holland.addStatistics(new Statistics("Arsenal", 1, 1, 8));


			everton.transferToSquad(mykolenko);
			everton.transferToSquad(garner);
			everton.transferToSquad(gueye);

			arsenal.transferToSquad(mykolenko);
			arsenal.transferToSquad(gueye);

			city.transferToSquad(mykolenko);
			city.transferToSquad(holland);

			teamRepository.saveAll(List.of(everton, arsenal, city));
		};
	}
}
