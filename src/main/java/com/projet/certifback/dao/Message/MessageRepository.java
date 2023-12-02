package com.projet.certifback.dao.message;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
    List<Message> findByChannelId(Long channelId);
    List<Message> findByUserId(Long userId);
}

