package com.projet.certifback.controller.message.dto;

import java.time.LocalDateTime;

import com.projet.certifback.controller.channel.dto.ChannelPostDTO;
import com.projet.certifback.controller.user.dto.UserPostDTO;

import java.util.Objects;


public class MessageDTO {

    private String content;
    private LocalDateTime timestamp;
    private ChannelPostDTO channel;
    private UserPostDTO user;


    public MessageDTO() {
    }

    public MessageDTO(String content, LocalDateTime timestamp, ChannelPostDTO channel, UserPostDTO user) {
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

    public ChannelPostDTO getChannel() {
        return this.channel;
    }

    public void setChannel(ChannelPostDTO channel) {
        this.channel = channel;
    }

    public UserPostDTO getUser() {
        return this.user;
    }

    public void setUser(UserPostDTO user) {
        this.user = user;
    }

    public MessageDTO content(String content) {
        setContent(content);
        return this;
    }

    public MessageDTO timestamp(LocalDateTime timestamp) {
        setTimestamp(timestamp);
        return this;
    }

    public MessageDTO channel(ChannelPostDTO channel) {
        setChannel(channel);
        return this;
    }

    public MessageDTO user(UserPostDTO user) {
        setUser(user);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof MessageDTO)) {
            return false;
        }
        MessageDTO messageDTO = (MessageDTO) o;
        return Objects.equals(content, messageDTO.content) && Objects.equals(timestamp, messageDTO.timestamp) && Objects.equals(channel, messageDTO.channel) && Objects.equals(user, messageDTO.user);
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
