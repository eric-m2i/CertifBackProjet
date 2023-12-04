package com.projet.certifback.controller.message.dto;

import java.time.LocalDateTime;

import com.projet.certifback.dao.entity.Channel;
import com.projet.certifback.dao.entity.User;

import java.util.Objects;


public class MessagePostDTO {

    private String content;
    private LocalDateTime timestamp;
    private Channel channel;
    private User user;


    public MessagePostDTO() {
    }

    public MessagePostDTO(String content, LocalDateTime timestamp, Channel channel, User user) {
        this.content = content;
        this.timestamp = timestamp;
        this.channel = channel;
        this.user = user;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getTimestamp() {
        return this.timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public Channel getChannel() {
        return this.channel;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public MessagePostDTO content(String content) {
        setContent(content);
        return this;
    }

    public MessagePostDTO timestamp(LocalDateTime timestamp) {
        setTimestamp(timestamp);
        return this;
    }

    public MessagePostDTO channel(Channel channel) {
        setChannel(channel);
        return this;
    }

    public MessagePostDTO user(User user) {
        setUser(user);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof MessagePostDTO)) {
            return false;
        }
        MessagePostDTO messagePostDTO = (MessagePostDTO) o;
        return Objects.equals(content, messagePostDTO.content) && Objects.equals(timestamp, messagePostDTO.timestamp) && Objects.equals(channel, messagePostDTO.channel) && Objects.equals(user, messagePostDTO.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(content, timestamp, channel, user);
    }

    @Override
    public String toString() {
        return "{" +
            " content='" + getContent() + "'" +
            ", timestamp='" + getTimestamp() + "'" +
            ", channel='" + getChannel() + "'" +
            ", user='" + getUser() + "'" +
            "}";
    }
    
    
}
