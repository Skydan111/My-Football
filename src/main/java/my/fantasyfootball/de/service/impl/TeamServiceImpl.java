package my.fantasyfootball.de.service.impl;

import my.fantasyfootball.de.model.Team;
import my.fantasyfootball.de.repository.TeamRepository;
import my.fantasyfootball.de.service.TeamService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TeamServiceImpl implements TeamService {

    private final TeamRepository teamRepository;

    public TeamServiceImpl(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @Override
    public List<Team> getAllTeams() {
        return (List<Team>) teamRepository.findAll();
    }

    @Override
    public Team getUserTeam(String userId) {
        UUID userUuid = UUID.fromString(userId);
        return null;
    }
}
