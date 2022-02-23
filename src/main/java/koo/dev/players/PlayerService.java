package koo.dev.players;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlayerService {

    private final PlayerRepository playerRepository;

    @Autowired
    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }


    public List<Player> getPlayers() {
        return playerRepository.findAll()
                .stream()
                .map(player -> new Player(player.getId(), player.getNickName()))
                .collect(Collectors.toList());


    }


    public List<Player> find(String query) {
        if (query == null || query.isBlank()) {
            return playerRepository.findAll()
                    .stream()
                    .map(player -> new Player(player.getId(), player.getNickName()))
                    .collect(Collectors.toList());
        }
        return playerRepository.findByNickname(query)
                .stream()
                .map(player -> new Player(player.getId(), player.getNickName()))
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
}
