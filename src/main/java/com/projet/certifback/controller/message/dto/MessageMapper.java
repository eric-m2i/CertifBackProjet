package com.projet.certifback.controller.message.dto;

import com.projet.certifback.controller.channel.dto.ChannelDTO;
import com.projet.certifback.controller.user.dto.UserDTO;
import com.projet.certifback.dao.entity.Message;


public class MessageMapper {

    public static MessageDTO convertFromEntityToDto(Message entity) {
        MessageDTO dto = new MessageDTO();
        dto.setId(entity.getId());
        // entity.getUser().setMessages(null);
        // entity.getChannel().setMessages(null);

        dto.setUser(new UserDTO());
        dto.getUser().setId(entity.getUser().getId());
        dto.getUser().setNom(entity.getUser().getNom());
        dto.getUser().setPrenom(entity.getUser().getPrenom());
        dto.getUser().setEmail(entity.getUser().getEmail());
        dto.getUser().setPseudo(entity.getUser().getPseudo());

        dto.setChannel(new ChannelDTO());
        dto.getChannel().setId(entity.getChannel().getId());
        dto.getChannel().setName(entity.getChannel().getName());
        dto.getChannel().setDescription(entity.getChannel().getDescription());                                                                           

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
