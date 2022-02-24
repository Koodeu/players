package koo.dev.players.service;

import koo.dev.players.entity.Player;
import koo.dev.players.entity.Team;
import koo.dev.players.repository.PlayerRepository;
import koo.dev.players.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import koo.dev.players.pojo.PlayerRequest;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlayerService {

    private final PlayerRepository playerRepository;

    @Autowired
    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @Autowired
    private TeamRepository teamRepository;


    public List<Player> getPlayers() {
        return playerRepository.findAll()
                .stream()
                .map(player -> new Player(player.getId(), player.getNickName(), player.getTeam()))
                .collect(Collectors.toList());


    }


    public List<Player> find(String query) {
        if (query == null || query.isBlank()) {
            return playerRepository.findAll()
                    .stream()
                    .map(player -> new Player(player.getId(), player.getNickName(), player.getTeam()))
                    .collect(Collectors.toList());
        }
        return playerRepository.findByNickname(query)
                .stream()
                .map(player -> new Player(player.getId(), player.getNickName(), player.getTeam()))
                .collect(Collectors.toList());
    }

    public void deletePlayer(Long playerId) {
        boolean exists = playerRepository.existsById(playerId);

        if (!exists) {
            throw new IllegalStateException("no player with " + playerId + " Id number found.");
        }
        playerRepository.deleteById(playerId);
    }

    public Player addPlayer(Player player) {
        return playerRepository.save(player);
    }

    public Player assignPlayerToTeam(Long playerId, Long teamId) {
        Player player = playerRepository.findById(playerId).get();
        Team team = teamRepository.findById(teamId).get();
        player.assignToTeam(team);
        return playerRepository.save(player);
    }

    public Player savePlayerWithTeam(PlayerRequest playerRequest) {
        Team team = teamRepository.findTeamById(playerRequest.getTeamId());
        Player player = new Player();
        player.setNickName(playerRequest.getPlayerNickname());
        player.setTeam(team);
        return playerRepository.save(player);
    }
}
