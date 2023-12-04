package com.projet.certifback.controller.channel.dto;

import java.util.ArrayList;
import java.util.List;

import com.projet.certifback.dao.entity.Channel;
import com.projet.certifback.dao.entity.Message;

public class ChannelMapper {
        public static ChannelPostDTO convertFromEntityToPostDto(Channel entity) {
        ChannelPostDTO postDTO = new ChannelPostDTO();
        postDTO.setDescription(entity.getDescription());
        postDTO.setName(entity.getName());
        return postDTO;
    }

    public static ChannelDTO convertFromEntityToDto(Channel entity) {
        ChannelDTO dto = new ChannelDTO();
        dto.setDescription(entity.getDescription());
        dto.setName(entity.getName());

        List<Message> messages = new ArrayList<>();
        for (Message message : entity.getMessages()) {
            message.setChannel(null);
            message.getUser().setMessages(null);
            messages.add(message);
        }
        dto.setMessages(messages);

        return dto;
    }

    public static Channel convertFromDtoToEntity(ChannelPostDTO dto) {
        Channel entity = new Channel();
        entity.setDescription(dto.getDescription());
        entity.setName(dto.getName());
        return entity;
    }
}
