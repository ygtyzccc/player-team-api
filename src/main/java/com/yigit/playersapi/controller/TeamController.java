package com.yigit.playersapi.controller;


import com.yigit.playersapi.service.PlayersApiService;
import com.yigit.playersapi.viewmodel.TeamViewModel;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/team")
public class TeamController {

    private PlayersApiService m_playersApiService;

    public TeamController(PlayersApiService playersApiService)
    {
        m_playersApiService = playersApiService;
    }

    @GetMapping("find")
    public Optional<TeamViewModel> findTeamById(long id)
    {
        return m_playersApiService.findTeamByTeamId(id);
    }

    @PostMapping("save")
    public TeamViewModel saveTeam(@RequestBody TeamViewModel teamViewModel)
    {
        return m_playersApiService.saveTeam(teamViewModel);
    }
}
