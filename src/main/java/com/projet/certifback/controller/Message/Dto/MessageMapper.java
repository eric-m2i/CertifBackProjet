package com.projet.certifback.controller.Message.Dto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;

import com.projet.certifback.controller.Channel.Dto.ChannelMapper;
import com.projet.certifback.controller.User.Dto.UserMapper;
import com.projet.certifback.dao.Message.Message;
import com.projet.certifback.service.ChatService;

import jakarta.websocket.server.PathParam;

public class MessageMapper {

    @Autowired
    private ChatService chatService;

    public static MessageDTO convertFromEntityToDto(Message entity) {
        MessageDTO dto = new MessageDTO();
        entity.getUser().setMessages(null);
        entity.getChannel().setMessages(null);
        dto.setUser(UserMapper.convertFromEntityToPostDto(entity.getUser())); // setUser est un UserPostTDO
        dto.setChannel(ChannelMapper.convertFromEntityToPostDto(entity.getChannel())); // setChannel est un
                                                                                       // ChannelPostTDO

        dto.setContent(entity.getContent());
        dto.setTimestamp(entity.getTimestamp());
        return dto;
    }

    public static Message convertFromDtoToEntity(MessagePostDTO dto) {
        Message entity = new Message();
        entity.setChannel(dto.getChannel());
        entity.setContent(dto.getContent());
        entity.setTimestamp(dto.getTimestamp());
        entity.setUser(dto.getUser());

        return entity;
    }

    // @DeleteMapping("/{messageId}")
    // public ResponseEntity<String> deleteMessage(@PathParam("messageId") Long messageId) {
    //     if (chatService.deleteMessage(messageId)) {
    //         return ResponseEntity.ok("Client deleted successfully");
    //     } else
    //         return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Client not found");
    // }

}
