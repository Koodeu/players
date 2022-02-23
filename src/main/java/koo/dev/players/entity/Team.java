package koo.dev.players.entity;

import koo.dev.players.entity.Player;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Component
@Entity
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String coachName;
    private String teamName;
//    @ElementCollection
//    private List<Player> listOfPlayers;


    public Team(String coachName, String teamName) {
        this.coachName = coachName;
        this.teamName = teamName;
    }
}
