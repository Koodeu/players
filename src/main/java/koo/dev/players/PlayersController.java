package koo.dev.players;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PlayersController {


    private PlayerService playerService;

    @Autowired
    public PlayersController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping(path = "/allplayers")
    public List<Player> getPlayers(){
       return playerService.getPlayers();
    }

    @GetMapping(path = "/player") //http://localhost:8080/player?query=koodeu
    public List<Player> findBy(@RequestParam(required = false) String query ){
        return playerService.find(query);
    }


    @DeleteMapping(path= "{playerId}")
    public void deletePlayer(@PathVariable("playerId") Long playerId){
        playerService.deletePlayer(playerId);
    }

    @PostMapping(path="/addplyer")
    public Player addplayer(@RequestBody Player player){
        return playerService.addPlayer(player);
    }


}

