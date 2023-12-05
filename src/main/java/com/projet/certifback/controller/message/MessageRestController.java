package com.projet.certifback.controller.message;

import com.projet.certifback.controller.message.dto.MessageDTO;
import com.projet.certifback.controller.message.dto.MessageMapper;
import com.projet.certifback.controller.message.dto.MessagePostDTO;
import com.projet.certifback.dao.entity.Message;
import com.projet.certifback.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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

    @PostMapping("{channelId}/users/{userId}/messages")
    public ResponseEntity<?> addMessage(@PathVariable("channelId") Long channelId,
            @PathVariable("userId") Long userId,
            @RequestBody MessagePostDTO messagePostDTO) {
        try {
            if (channelId.equals(messagePostDTO.getChannel().getId()) &&
                    userId.equals(messagePostDTO.getUser().getId())) {

                Message message = MessageMapper.convertFromDtoToEntity(messagePostDTO);
                chatService.addMessage(channelId, userId, message);

                return ResponseEntity
                        .status(HttpStatus.CREATED)
                        .body("Message ajouté avec succès");
            } else {
                return ResponseEntity
                        .status(HttpStatus.UNAUTHORIZED)
                        .body("Message pas ajouté car non correspondance des identifiants");
            }
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Une erreur s'est produite lors de l'ajout du message." + e.getMessage());
        }
    }

}
