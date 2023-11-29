package com.projet.certifback.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.projet.certifback.dao.Channel;
import com.projet.certifback.service.ChatService;

@RestController
@RequestMapping("/api/channels")
public class ChannelRestController {
    @Autowired
    private ChatService chatService;

    @GetMapping
    public List<Channel> getAllChannels() {
        return chatService.getAllChannels();
    }

    @PostMapping
    public Channel createChannel(@RequestParam String channelName) {
        return chatService.createChannel(channelName);
    }

    @DeleteMapping("/{channelId}")
    public void deleteChannel(@PathVariable Long channelId) {
        chatService.deleteChannel(channelId);
    }
}

