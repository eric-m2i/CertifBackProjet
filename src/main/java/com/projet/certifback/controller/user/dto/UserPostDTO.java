package com.projet.certifback.controller.user.dto;
import java.util.Objects;


public class UserPostDTO {

    private String nom;
    private String prenom;
    private String email;
    private String pseudo;


    public UserPostDTO() {
    }

    public UserPostDTO(String nom, String prenom, String email, String pseudo) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.pseudo = pseudo;
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

    public UserPostDTO nom(String nom) {
        setNom(nom);
        return this;
    }

    public UserPostDTO prenom(String prenom) {
        setPrenom(prenom);
        return this;
    }

    public UserPostDTO email(String email) {
        setEmail(email);
        return this;
    }

    public UserPostDTO pseudo(String pseudo) {
        setPseudo(pseudo);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof UserPostDTO)) {
            return false;
        }
        UserPostDTO userPostDTO = (UserPostDTO) o;
        return Objects.equals(nom, userPostDTO.nom) && Objects.equals(prenom, userPostDTO.prenom) && Objects.equals(email, userPostDTO.email) && Objects.equals(pseudo, userPostDTO.pseudo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom, prenom, email, pseudo);
    }

    @Override
    public String toString() {
        return "{" +
            " nom='" + getNom() + "'" +
            ", prenom='" + getPrenom() + "'" +
            ", email='" + getEmail() + "'" +
            ", pseudo='" + getPseudo() + "'" +
            "}";
    }
    
}
