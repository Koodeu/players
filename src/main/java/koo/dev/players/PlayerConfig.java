package koo.dev.players;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class PlayerConfig {


    @Bean
    CommandLineRunner commandLineRunner(PlayerRepository playerRepository) {
        return args -> {
            Player player1 = new Player("koodeu");
            Player player2 = new Player("lester");
            Player player3 = new Player("rocker");


            playerRepository.saveAll(List.of(player1, player2, player3));
        };

    }
}
