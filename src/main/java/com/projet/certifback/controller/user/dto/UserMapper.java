package com.projet.certifback.controller.user.dto;


import com.projet.certifback.dao.entity.User;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(target = "messages", source = "entity.messages")
    @AfterMapping
    default void ignoreUserAndChannelInMessages(@MappingTarget UserDTO userDTO) {
        userDTO.getMessages().forEach(
                messageDTO -> {
                    messageDTO.setChannel(null);
                    messageDTO.setUser(null);
                });
    }

    UserDTO convertFromEntityToDto(User entity);

    UserPostDTO convertFromEntityToPostDto(User entity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "messages", ignore = true)
    User convertFromDtoToEntity(UserPostDTO dto);

}
