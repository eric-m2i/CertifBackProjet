package com.projet.certifback.controller.user.dto;

import java.util.ArrayList;
import java.util.List;

import com.projet.certifback.dao.entity.Message;
import com.projet.certifback.dao.entity.User;

public class UserMapper {

    public static UserPostDTO convertFromEntityToPostDto(User entity) {
        UserPostDTO postDTO = new UserPostDTO();
        postDTO.setEmail(entity.getEmail());
        postDTO.setNom(entity.getNom());
        postDTO.setPrenom(entity.getPrenom());
        postDTO.setPseudo(entity.getPseudo());
        return postDTO;
    }

    public static UserDTO convertFromEntityToDto(User entity) {
        UserDTO dto = new UserDTO();
        dto.setId(entity.getId());
        dto.setEmail(entity.getEmail());
        dto.setNom(entity.getNom());
        dto.setPrenom(entity.getPrenom());
        dto.setPseudo(entity.getPseudo());

        List<Message> messages = new ArrayList<>();
        for (Message message : entity.getMessages()) {
            message.getChannel().setMessages(null);
            message.setUser(null);
            messages.add(message);
        }
        dto.setMessages(messages);

        return dto;
    }

    public static User convertFromDtoToEntity(UserPostDTO dto) {
        User entity = new User();
        entity.setEmail(dto.getEmail());
        entity.setNom(dto.getNom());
        entity.setPrenom(dto.getPrenom());
        entity.setPseudo(dto.getPseudo());
        return entity;
    }

}
