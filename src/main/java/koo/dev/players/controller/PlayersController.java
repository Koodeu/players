package koo.dev.players.controller;

import koo.dev.players.entity.Player;
import koo.dev.players.entity.Team;
import koo.dev.players.repository.PlayerRepository;
import koo.dev.players.repository.TeamRepository;
import koo.dev.players.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pojo.PlayerRequest;

import java.util.List;

@RestController
public class PlayersController {


    private PlayerService playerService;

    @Autowired
    public PlayersController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @Autowired
    private PlayerRepository playerRepository;


    @GetMapping(path = "/allplayers")
    public List<Player> getPlayers() {
        return playerService.getPlayers();
    }

    @GetMapping(path = "/player") //http://localhost:8080/player?query=koodeu
    public List<Player> findByNickname(@RequestParam(required = false) String query) {
        return playerService.find(query);
    }


    @DeleteMapping(path = "{playerId}")
    public void deletePlayer(@PathVariable("playerId") Long playerId) {
        playerService.deletePlayer(playerId);
    }

    @PostMapping(path = "/addplayer", produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Player addplayer(@RequestBody Player player) {
        return playerService.addPlayer(player);
    }


    @PutMapping("/{playerId}/player/{teamId}")
    public Player assignPlayerToTeam(
            @PathVariable Long playerId,
            @PathVariable Long teamId) {

        return playerService.assignPlayerToTeam(playerId, teamId);
    }

    @PostMapping(path = "savePlayerWithTeam", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Player savePlayerWithTeam(@RequestBody PlayerRequest playerRequest){
            return playerService.savePlayerWithTeam(playerRequest);

    }


}




