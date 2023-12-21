package com.projet.certifback.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.certifback.controller.channel.dto.ChannelDTO;
import com.projet.certifback.controller.channel.dto.ChannelMapper;
import com.projet.certifback.controller.channel.dto.ChannelPostDTO;
import com.projet.certifback.dao.entity.Channel;
import com.projet.certifback.dao.entity.Message;
import com.projet.certifback.dao.entity.User;
import com.projet.certifback.dao.repository.ChannelRepository;
import com.projet.certifback.dao.repository.MessageRepository;
import com.projet.certifback.dao.repository.UserRepository;

@Service
public class ChatService {

    public static final String CANAL_GENERAL = "GENERAL";

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
        if (!newChannel.getName().equalsIgnoreCase(CANAL_GENERAL)) {
            return channelRepository.save(newChannel);
        }
        return null;
    }

    public Channel updateChannel(Channel updateChannel, Long channelId) {
        Channel existingChannel = getChannelById(channelId);
        if (existingChannel != null && !existingChannel.getName().equals(CANAL_GENERAL)) {
            updateChannel.setId(existingChannel.getId());
            updateChannel.setMessages(existingChannel.getMessages());
            return updateChannel;
        }
        return null;
    }

    public Channel patchChannel(Channel channelPatch, Long id) {
        Channel existingChannel = getChannelById(id);

        if (existingChannel != null) {
            if (channelPatch.getName() != null && !existingChannel.getName().equals(CANAL_GENERAL)) {
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
        if (channelRecup != null && !channelRecup.getName().equals(CANAL_GENERAL)) {
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

    public Message addMessage(Long channelId, Long userId, Message content) {
        Channel channel = channelRepository.findById(channelId).orElse(null);
        User user = userRepository.findById(userId).orElse(null);

        if (channel != null && user != null) {
            Message message = new Message();
            message.setContent(content.getContent());
            message.setTimestamp(LocalDateTime.now());
            message.setChannel(channel);
            message.setUser(user);

            return messageRepository.save(message);
        }
        return null;
    }

    //////////////////////////////// MAPPER //////////////////////////////////

    // @Autowired
    // private ChannelMapper channelMapper;

    // public ChannelDTO convertChannelToDTO(Channel channel) {
    //     return channelMapper.convertChannelToDTO(channel);
    // }

    // public ChannelPostDTO convertChannelToPostDTO(Channel channel) {
    //     return channelMapper.convertChannelToPostDTO(channel);
    // }

    // public Channel convertDTOToChannel(ChannelPostDTO channelPostDTO) {
    //     return channelMapper.convertDTOToChannel(channelPostDTO);
    // }

    // public List<ChannelDTO> convertListChannelToDTO(List<Channel> channels) {
    //     return channelMapper.convertListChannelToDTO(channels);
    // }
}
