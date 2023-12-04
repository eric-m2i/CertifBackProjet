package com.projet.certifback.controller.message.dto;

import com.projet.certifback.controller.channel.dto.ChannelMapper;
import com.projet.certifback.controller.user.dto.UserMapper;
import com.projet.certifback.dao.entity.Message;


public class MessageMapper {

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
