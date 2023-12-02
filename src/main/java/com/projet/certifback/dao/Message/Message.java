package com.projet.certifback.dao.message;

import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.Objects;

import com.projet.certifback.dao.channel.Channel;
import com.projet.certifback.dao.user.User;

@Entity
@Table(name = "messages")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "contenu_message",nullable = false, length = 100)
    private String content;

    @Column(name = "date_heure",nullable = false)
    private LocalDateTime timestamp;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "channel_id", referencedColumnName = "id")
    private Channel channel;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;


    public Message() {
    }

    public Message(String content, LocalDateTime timestamp, Channel channel, User user) {
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

    public Message id(Long id) {
        setId(id);
        return this;
    }

    public Message content(String content) {
        setContent(content);
        return this;
    }

    public Message timestamp(LocalDateTime timestamp) {
        setTimestamp(timestamp);
        return this;
    }

    public Message channel(Channel channel) {
        setChannel(channel);
        return this;
    }

    public Message user(User user) {
        setUser(user);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Message)) {
            return false;
        }
        Message message = (Message) o;
        return Objects.equals(id, message.id) && Objects.equals(content, message.content) && Objects.equals(timestamp, message.timestamp) && Objects.equals(channel, message.channel) && Objects.equals(user, message.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, content, timestamp, channel, user);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", content='" + getContent() + "'" +
            ", timestamp='" + getTimestamp() + "'" +
            ", channel_id='" + getChannel().getId() + "'" +
            ", user_pseudo='" + getUser().getPseudo() + "'" +
            "}";
    }

}