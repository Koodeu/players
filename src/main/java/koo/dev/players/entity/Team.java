package koo.dev.players.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import koo.dev.players.entity.Player;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Component
@Entity
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "team_coach_name")
    private String coachName;
    @Column(name =  "team_name")
    private String teamName;

    @JsonIgnore
    @OneToMany(mappedBy = "team")
    private Set<Player> teamMembers = new HashSet<>();

//    @ElementCollection
//    private List<Player> listOfPlayers;


    public Team(String coachName, String teamName) {
        this.coachName = coachName;
        this.teamName = teamName;
    }


    @Override
    public String toString() {
        return "Team{" +
                "id=" + id +
                ", coachName='" + coachName + '\'' +
                ", teamName='" + teamName + '\'' +
                ", teamMembers=" + teamMembers +
                '}';
    }
}
