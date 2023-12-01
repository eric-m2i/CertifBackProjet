package com.projet.certifback.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.certifback.dao.Channel.Channel;
import com.projet.certifback.dao.Channel.ChannelRepository;
import com.projet.certifback.dao.Message.Message;
import com.projet.certifback.dao.Message.MessageRepository;
import com.projet.certifback.dao.User.User;
import com.projet.certifback.dao.User.UserRepository;

@Service
public class ChatService {
    @Autowired
    private ChannelRepository channelRepository;

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private UserRepository userRepository;

    public List<Channel> getAllChannels() {
        return channelRepository.findAll();
    }

    public Channel getChannelById(Long channelId) {
        return channelRepository.findById(channelId).orElse(null);
    }

    public Channel saveChannel(Channel newChannel) {
        return channelRepository.save(newChannel);
    }

    public Channel updateChannel(Channel updateChannel, Long channelId) {
        Channel existingChannel = getChannelById(channelId);
        if (existingChannel != null && existingChannel.getName().equals("GENERAL")) {
            updateChannel.setId(existingChannel.getId());
            return updateChannel;
        }
        return null;
    }

    public Channel patchChannel(Channel channelPatch, Long id) {
        Channel existingChannel = getChannelById(id);

        if (existingChannel != null) {
            if (channelPatch.getName() != null && !existingChannel.getName().equals("GENERAL")) {
                existingChannel.setName(channelPatch.getName());
            }
            if (channelPatch.getDescription() != null) {
                existingChannel.setDescription(channelPatch.getDescription());
            }

            return existingChannel;
        }

        return null;
    }

    public Boolean deleteChannel(Long channelId) {
        Channel channelRecup = getChannelById(channelId);
        if (channelRecup != null && !channelRecup.getName().equals("GENERAL")) {
            channelRepository.deleteById(channelId);
            return true;
        }
        return false;
    }

    public User saveUser(User newUser) {
        return userRepository.save(newUser);
    }

    public User getUserById(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public List<Message> getMessagesByChannel(Long channelId) {
        return messageRepository.findByChannelId(channelId);
    }

    public List<Message> getMessagesByUser(Long channelId) {
        return messageRepository.findByUserId(channelId);
    }

    public Message getMessageById(Long messageId) {
        return messageRepository.findById(messageId).orElse(null);
    }

    public Boolean deleteMessage(Long messageId) {
        Message messageRecup = getMessageById(messageId);
        if (messageRecup != null) {
            messageRepository.deleteById(messageId);
            return true;
        }
        return false;
    }

    public Message addMessage(Long channelId,Long userId, String content) {
        Channel channel = channelRepository.findById(channelId).orElse(null);
        User User = userRepository.findById(userId).orElse(null);

        if (channel != null) {
            Message message = new Message();
            message.setContent(content);
            message.setTimestamp(LocalDateTime.now());
            message.setChannel(channel);
            message.setUser(User);

            return messageRepository.save(message);
        }
        return null;
    }
}
