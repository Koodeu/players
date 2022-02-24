package koo.dev.players.repository;

import koo.dev.players.entity.Player;
import koo.dev.players.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {

    @Query("select p from Player p where p.nickName like concat('%', ?1, '%')")
    List<Player> findByNickname(String query);




}
