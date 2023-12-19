package com.projet.certifback.controller.message.dto;

import java.time.LocalDateTime;

import com.projet.certifback.controller.channel.dto.ChannelDTO;
import com.projet.certifback.controller.user.dto.UserDTO;

import java.util.Objects;


public class MessageDTO {

    private Long id;
    private String content;
    private LocalDateTime timestamp;
    private ChannelDTO channel;
    private UserDTO user;


    public MessageDTO() {
    }

    public MessageDTO(String content, LocalDateTime timestamp, ChannelDTO channel, UserDTO user) {
        this.content = content;
        this.timestamp = timestamp;
        this.channel = channel;
        this.user = user;
    }


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public ChannelDTO getChannel() {
        return this.channel;
    }

    public void setChannel(ChannelDTO channel) {
        this.channel = channel;
    }

    public UserDTO getUser() {
        return this.user;
    }

    public void setUser(UserDTO user) {
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

    public MessageDTO channel(ChannelDTO channel) {
        setChannel(channel);
        return this;
    }

    public MessageDTO user(UserDTO user) {
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
