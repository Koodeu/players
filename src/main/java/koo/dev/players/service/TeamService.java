package koo.dev.players.service;

import koo.dev.players.entity.Team;
import koo.dev.players.repository.TeamRepository;
import koo.dev.players.responses.TeamResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService {

    private TeamRepository teamRepository;

    @Autowired
    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }


    public Team addTeam(Team team) {
        return teamRepository.save(team);
    }

    public List<TeamResponse> getTeamWithPlayers() {
        return teamRepository.getTeamWithPlayers();
    }
}
