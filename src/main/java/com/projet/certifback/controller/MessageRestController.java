package com.projet.certifback.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.projet.certifback.dao.Message;
import com.projet.certifback.service.ChatService;

@RestController
@RequestMapping("/api/channels/{channelId}/messages")
public class MessageRestController {
    @Autowired
    private ChatService chatService;

    @GetMapping
    public List<Message> getMessagesByChannel(@PathVariable Long channelId) {
        return chatService.getMessagesByChannel(channelId);
    }

    @PostMapping
    public Message addMessage(@PathVariable Long channelId, @RequestParam String content) {
        return chatService.addMessage(channelId, content);
    }
}

