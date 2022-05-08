package com.yigit.playersapi.controller;

import com.yigit.playersapi.service.PlayersApiService;
import com.yigit.playersapi.viewmodel.PlayerSaveDTO;
import com.yigit.playersapi.viewmodel.PlayerViewModel;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/player")
public class PlayerController {

    private PlayersApiService m_playersApiService;

    public PlayerController(PlayersApiService playersApiService)
    {
        m_playersApiService = playersApiService;
    }

    @GetMapping("find")
    public Optional<PlayerViewModel> findPlayerById(long id)
    {
        return m_playersApiService.findPlayerByPlayerId(id);
    }

    @PostMapping("save")
    public PlayerSaveDTO savePlayer(@RequestBody PlayerSaveDTO playerSaveDTO)
    {
        return m_playersApiService.savePlayer(playerSaveDTO);
    }
}
