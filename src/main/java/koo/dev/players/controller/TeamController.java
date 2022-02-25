package koo.dev.players.controller;

import koo.dev.players.entity.Team;
import koo.dev.players.repository.TeamRepository;
import koo.dev.players.responses.TeamResponse;
import koo.dev.players.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TeamController {

    private TeamService teamService;

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }


    @PostMapping(path = "/team", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Team addTeam(@RequestBody Team team){
        return teamService.addTeam(team);
    }


    @GetMapping("teamWithPlayers")
    public List<TeamResponse> getTeamsWithPlayers(){
        return teamService.getTeamWithPlayers();
    }


}
