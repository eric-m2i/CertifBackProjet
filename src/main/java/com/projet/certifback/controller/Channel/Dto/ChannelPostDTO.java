package com.projet.certifback.controller.Channel.Dto;
import java.util.Objects;

public class ChannelPostDTO {
    private String name;
    private String description;


    public ChannelPostDTO() {
    }

    public ChannelPostDTO(String name, String description) {
        this.name = name;
        this.description = description;
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

    public ChannelPostDTO name(String name) {
        setName(name);
        return this;
    }

    public ChannelPostDTO description(String description) {
        setDescription(description);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ChannelPostDTO)) {
            return false;
        }
        ChannelPostDTO chanelPostDTO = (ChannelPostDTO) o;
        return Objects.equals(name, chanelPostDTO.name) && Objects.equals(description, chanelPostDTO.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description);
    }

    @Override
    public String toString() {
        return "{" +
            " name='" + getName() + "'" +
            ", description='" + getDescription() + "'" +
            "}";
    }
    
}
