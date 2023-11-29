package com.projet.certifback.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.certifback.dao.Channel;
import com.projet.certifback.dao.ChannelRepository;
import com.projet.certifback.dao.Message;
import com.projet.certifback.dao.MessageRepository;

@Service
public class ChatService {
    @Autowired
    private ChannelRepository channelRepository;

    @Autowired
    private MessageRepository messageRepository;

    public List<Channel> getAllChannels() {
        return channelRepository.findAll();
    }

    public Channel getChannelById(Long channelId) {
        return channelRepository.findById(channelId).orElse(null);
    }

    public Channel createChannel(String channelName) {
        Channel channel = new Channel();
        channel.setName(channelName);
        return channelRepository.save(channel);
    }

    public void deleteChannel(Long channelId) {
        channelRepository.deleteById(channelId);
    }

    public List<Message> getMessagesByChannel(Long channelId) {
        return messageRepository.findByChannelId(channelId);
    }

    public Message addMessage(Long channelId, String content) {
        Channel channel = channelRepository.findById(channelId).orElse(null);

        if (channel != null) {
            Message message = new Message();
            message.setContent(content);
            message.setTimestamp(LocalDateTime.now());
            message.setChannel(channel);

            return messageRepository.save(message);
        }
        return null;
    }
}
