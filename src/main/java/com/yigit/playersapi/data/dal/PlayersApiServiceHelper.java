package com.yigit.playersapi.data.dal;

import com.yigit.playersapi.data.entity.Player;
import com.yigit.playersapi.data.entity.Team;
import com.yigit.playersapi.data.repository.IPlayerRepository;
import com.yigit.playersapi.data.repository.ITeamRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class PlayersApiServiceHelper {

    private IPlayerRepository m_playerRepository;
    private ITeamRepository m_teamRepository;

    public PlayersApiServiceHelper(IPlayerRepository playerRepository, ITeamRepository teamRepository) {
        m_playerRepository = playerRepository;
        m_teamRepository = teamRepository;
    }

    public boolean existTeamById(long id)
    {
        return m_teamRepository.existsById(id);
    }

    public boolean existPlayerById(long id)
    {
        return m_playerRepository.existsById(id);
    }

    public Iterable<Player> findPlayersByTeamId(long id)
    {

        return m_playerRepository.findByTeam(id);

    }

    public Optional<Team> findTeamByTeamId(long id)
    {
        return m_teamRepository.findById(id);
    }

    public Optional<Player> findPlayerByPlayerId(long id)
    {

        return m_playerRepository.findById(id);
    }

    public Team saveTeam(Team team)
    {
        return m_teamRepository.save(team);
    }

    public Player savePlayer(Player player)
    {
        var team = m_teamRepository.findById(player.getTeamId()).orElseThrow();

        player.setTeam(team);

        return m_playerRepository.save(player);
    }


}
