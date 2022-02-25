package koo.dev.players.repository;

import koo.dev.players.entity.Team;
import koo.dev.players.responses.TeamResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TeamRepository extends JpaRepository<Team, Long> {
    Team findTeamById(Long id);

    @Query("SELECT new koo.dev.players.responses.TeamResponse(t.teamName, p.nickName) FROM Team t join t.teamMembers p")
    List<TeamResponse> getTeamWithPlayers();


}
