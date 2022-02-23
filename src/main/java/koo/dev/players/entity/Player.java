package koo.dev.players.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nickName;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "team_id", referencedColumnName = "id")
    private Team team;


    public Team getTeam() {
        return team;
    }

    public Player(String nickName) {
        this.nickName = nickName;

    }
    public Player(Long id, String nickName) {
        this.id = id;
        this.nickName = nickName;
    }

    public void assignToTeam(Team team) {
        this.team = team;
    }
}