package com.projet.certifback.controller.message;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projet.certifback.controller.message.dto.MessageDTO;
import com.projet.certifback.controller.message.dto.MessageMapper;
import com.projet.certifback.controller.message.dto.MessagePostDTO;
import com.projet.certifback.dao.entity.Message;
import com.projet.certifback.service.ChatService;

@RestController
@RequestMapping("api/channels")
public class MessageRestController {
    @Autowired
    private ChatService chatService;

    @GetMapping("{channelId}/messages")
    public ResponseEntity<?> getMessagesByChannel(@PathVariable("channelId") Long channelId) {
        List<Message> entities = chatService.getMessagesByChannel(channelId);
        List<MessageDTO> dtos = new ArrayList<>();
        for (Message entity : entities)
            dtos.add(MessageMapper.convertFromEntityToDto(entity));

        return ResponseEntity.ok().body(dtos);
    }

    @PostMapping("{channelId}/{userId}/messages")
    public ResponseEntity<?> addMessage(@PathVariable("channelId") Long channelId,
            @PathVariable("userId") Long userId,
            @RequestBody MessagePostDTO messagePostDTO) {
        try {
            Message message = MessageMapper.convertFromDtoToEntity(messagePostDTO);
            chatService.addMessage(channelId, userId, message);

            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body("Message Ajouter avec Succes");
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Une erreur s'est produite lors de l'ajout du message." + e.getMessage());
        }
    }

}
