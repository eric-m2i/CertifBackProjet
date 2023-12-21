package com.projet.certifback.controller.message.dto;

import com.projet.certifback.dao.entity.Message;

import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface MessageMapper {

    MessageMapper INSTANCE = Mappers.getMapper(MessageMapper.class);

    @Mapping(target = "channel", source = "entity.channel")
    @Mapping(target = "user", source = "entity.user")
    @AfterMapping
    default void ignoreUserAndChannel(@MappingTarget MessageDTO messageDTO) {
        if (messageDTO.getChannel() != null) {
            messageDTO.getChannel().setMessages(null);
        }

        if (messageDTO.getUser() != null) {
            messageDTO.getUser().setMessages(null);
        }
    }

    MessageDTO convertFromEntityToDto(Message entity);

    @Mapping(target = "id", ignore = true)
    Message convertFromDtoToEntity(MessagePostDTO dto);

}
