package com.projet.certifback.controller.channel.dto;

import java.util.List;
import java.util.Objects;

import com.projet.certifback.dao.entity.Message;

public class ChannelDTO {
    private Long id;
    private String name;
    private String description;
    private List<Message> messages;


    public ChannelDTO() {
    }

    public ChannelDTO(String name, String description, List<Message> messages) {
        this.name = name;
        this.description = description;
        this.messages = messages;
    }


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Message> getMessages() {
        return this.messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public ChannelDTO name(String name) {
        setName(name);
        return this;
    }

    public ChannelDTO description(String description) {
        setDescription(description);
        return this;
    }

    public ChannelDTO messages(List<Message> messages) {
        setMessages(messages);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ChannelDTO)) {
            return false;
        }
        ChannelDTO chanelDTO = (ChannelDTO) o;
        return Objects.equals(name, chanelDTO.name) && Objects.equals(description, chanelDTO.description) && Objects.equals(messages, chanelDTO.messages);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, messages);
    }

    @Override
    public String toString() {
        return "{" +
            " name='" + getName() + "'" +
            ", description='" + getDescription() + "'" +
            ", messages='" + getMessages() + "'" +
            "}";
    }
    

}
