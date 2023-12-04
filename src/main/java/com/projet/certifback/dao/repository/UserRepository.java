package com.projet.certifback.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projet.certifback.dao.entity.User;


@Repository
public interface UserRepository extends JpaRepository<User,Long>  {
    User findByPseudo(String pseudo);
    
}
