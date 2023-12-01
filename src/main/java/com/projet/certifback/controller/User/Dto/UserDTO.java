package com.projet.certifback.controller.User.Dto;

import java.util.List;
import java.util.Objects;

import com.projet.certifback.dao.Message.Message;

public class UserDTO {
    private String nom;
    private String prenom;
    private String email;
    private String pseudo;
    private List<Message> messages;


    public UserDTO() {
    }

    public UserDTO(String nom, String prenom, String email, String pseudo, List<Message> messages) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.pseudo = pseudo;
        this.messages = messages;
    }

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return this.prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPseudo() {
        return this.pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public List<Message> getMessages() {
        return this.messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public UserDTO nom(String nom) {
        setNom(nom);
        return this;
    }

    public UserDTO prenom(String prenom) {
        setPrenom(prenom);
        return this;
    }

    public UserDTO email(String email) {
        setEmail(email);
        return this;
    }

    public UserDTO pseudo(String pseudo) {
        setPseudo(pseudo);
        return this;
    }

    public UserDTO messages(List<Message> messages) {
        setMessages(messages);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof UserDTO)) {
            return false;
        }
        UserDTO userDTO = (UserDTO) o;
        return Objects.equals(nom, userDTO.nom) && Objects.equals(prenom, userDTO.prenom) && Objects.equals(email, userDTO.email) && Objects.equals(pseudo, userDTO.pseudo) && Objects.equals(messages, userDTO.messages);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom, prenom, email, pseudo, messages);
    }

    @Override
    public String toString() {
        return "{" +
            " nom='" + getNom() + "'" +
            ", prenom='" + getPrenom() + "'" +
            ", email='" + getEmail() + "'" +
            ", pseudo='" + getPseudo() + "'" +
            ", messages='" + getMessages() + "'" +
            "}";
    }
    
}
