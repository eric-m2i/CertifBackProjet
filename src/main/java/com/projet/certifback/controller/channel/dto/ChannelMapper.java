package com.projet.certifback.controller.channel.dto;

import com.projet.certifback.dao.entity.Channel;

import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ChannelMapper {

    ChannelMapper INSTANCE = Mappers.getMapper(ChannelMapper.class);

    @Mapping(target = "messages", source = "entity.messages")
    @AfterMapping
    default void ignoreUserAndChannelInMessages(@MappingTarget ChannelDTO channelDTO) {
        channelDTO.getMessages().forEach(
                messageDTO -> {
                    messageDTO.setChannel(null);
                    messageDTO.setUser(null);
                });
    }

    ChannelDTO convertChannelToDTO(Channel entity);

    ChannelPostDTO convertChannelToPostDTO(Channel entity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "messages", ignore = true)
    Channel convertDTOToChannel(ChannelPostDTO dto);

    // List<ChannelDTO> convertListChannelToDTO(List<Channel> entities);

}
