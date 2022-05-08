package com.yigit.playersapi.data.repository;

import com.yigit.playersapi.data.entity.Player;
import com.yigit.playersapi.data.entity.Team;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface IPlayerRepository extends CrudRepository<Player, Long> {

    @Query("Select p from Player p where p.team.id = :teamId")
    Iterable<Player> findByTeam(long teamId);

}
