package com.yigit.playersapi.mapper;

import com.yigit.playersapi.data.entity.Player;
import com.yigit.playersapi.viewmodel.PlayerSaveDTO;
import com.yigit.playersapi.viewmodel.PlayerViewModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;


@Mapper(implementationName = "PlayerMapperImpl", componentModel = "spring")
public interface IPlayerMapper {
    PlayerViewModel toPLayerViewModel(Player player);
    PlayerViewModel toPlayerViewModel(PlayerSaveDTO playerSaveDTO);

    @Mappings(@Mapping(source = "teamId", target = "teamId"))
    Player toPlayer(PlayerSaveDTO playerSaveDTO);
    @Mappings(@Mapping(source = "teamId", target = "teamId"))
    PlayerSaveDTO toPlayerSaveDTO(Player player);


}
