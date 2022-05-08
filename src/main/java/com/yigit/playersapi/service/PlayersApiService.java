package com.yigit.playersapi.service;

import com.yigit.playersapi.data.dal.PlayersApiServiceHelper;
import com.yigit.playersapi.data.entity.Player;
import com.yigit.playersapi.data.entity.Team;
import com.yigit.playersapi.mapper.IPlayerMapper;
import com.yigit.playersapi.mapper.ITeamMapper;
import com.yigit.playersapi.viewmodel.PlayerSaveDTO;
import com.yigit.playersapi.viewmodel.PlayerViewModel;
import com.yigit.playersapi.viewmodel.TeamViewModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class PlayersApiService {

    private PlayersApiServiceHelper m_playersApiServiceHelper;
    private IPlayerMapper m_playerMapper;
    private ITeamMapper m_teamMapper;

    public PlayersApiService(PlayersApiServiceHelper playersApiServiceHelper, IPlayerMapper playerMapper, ITeamMapper teamMapper) {
        m_playersApiServiceHelper = playersApiServiceHelper;
        m_playerMapper = playerMapper;
        m_teamMapper = teamMapper;
    }

    public boolean existTeamById(long id)
    {
        return m_playersApiServiceHelper.existTeamById(id);
    }

    public boolean existPlayerById(long id)
    {
        return  m_playersApiServiceHelper.existPlayerById(id);
    }

    public List<PlayerViewModel> findPlayersByTeamId(long id)
    {
        var players = m_playersApiServiceHelper.findPlayersByTeamId(id);

        return StreamSupport.stream(players.spliterator(), true).map(m_playerMapper::toPLayerViewModel).collect(Collectors.toList());

    }

    public Optional<TeamViewModel> findTeamByTeamId(long id)
    {
        var team = m_playersApiServiceHelper.findTeamByTeamId(id).orElseThrow();

        return Optional.of(m_teamMapper.toTeamViewModel(team));
    }

    public Optional<PlayerViewModel> findPlayerByPlayerId(long id)
    {
        var player = m_playersApiServiceHelper.findPlayerByPlayerId(id).orElseThrow();

        return Optional.of(m_playerMapper.toPLayerViewModel(player));
    }

    public TeamViewModel saveTeam(TeamViewModel teamViewModel)
    {
        return m_teamMapper.toTeamViewModel(m_playersApiServiceHelper.saveTeam(m_teamMapper.toTeam(teamViewModel)));
    }

    public PlayerSaveDTO savePlayer(PlayerSaveDTO playerSaveDTO)
    {
       return m_playerMapper.toPlayerSaveDTO(m_playersApiServiceHelper.savePlayer(m_playerMapper.toPlayer(playerSaveDTO)));
    }
}
