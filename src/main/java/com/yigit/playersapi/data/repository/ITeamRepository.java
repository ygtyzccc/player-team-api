package com.yigit.playersapi.data.repository;

import com.yigit.playersapi.data.entity.Team;
import org.springframework.data.repository.CrudRepository;

public interface ITeamRepository extends CrudRepository<Team, Long> {
}
