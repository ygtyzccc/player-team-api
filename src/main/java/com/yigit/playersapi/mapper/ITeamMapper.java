package com.yigit.playersapi.mapper;

import com.yigit.playersapi.data.entity.Team;
import com.yigit.playersapi.viewmodel.TeamViewModel;
import org.mapstruct.Mapper;

@Mapper(implementationName = "TeamMapperImpl", componentModel = "spring")
public interface ITeamMapper {
    TeamViewModel toTeamViewModel(Team team);
    Team toTeam(TeamViewModel teamViewModel);
}
