package com.projet.certifback.controller.Message;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projet.certifback.controller.Message.Dto.MessageMapper;
import com.projet.certifback.controller.Message.Dto.MessagePostDTO;
import com.projet.certifback.dao.Message.Message;
import com.projet.certifback.service.ChatService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("api")
public class MessageRestController {
    @Autowired
    private ChatService chatService;

    @GetMapping("{channelId}/messages")
    public List<Message> getMessagesByChannel(@PathVariable("channelId") Long channelId) {
        return chatService.getMessagesByChannel(channelId);
    }

    @PostMapping("{channelId}/{userId}/messages")
    public Message addMessage(@PathVariable("channelId") Long channelId, @PathVariable("userId") Long userId,
            @RequestBody MessagePostDTO messagePostDTO) {
        Message message = MessageMapper.convertFromDtoToEntity(messagePostDTO);
        return chatService.addMessage(channelId, userId, message.getContent());
    }


}
