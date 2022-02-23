package koo.dev.players.configuration;

import koo.dev.players.entity.Player;
import koo.dev.players.repository.PlayerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

//class for automatic inserting 3 objects into DB
@Configuration
public class PlayerConfig {


    @Bean
    CommandLineRunner commandLineRunner(PlayerRepository playerRepository) {
        return args -> {
            	List<Player> teamOfPlayers = new ArrayList<>();

            Player player1 = new Player("koodeu");
            Player player2 = new Player("lester");
            Player player3 = new Player("rocker");

            teamOfPlayers.add(player1);
            teamOfPlayers.add(player2);
            teamOfPlayers.add(player3);

            playerRepository.saveAll(List.of(player1, player2, player3));
        };

    }
}
