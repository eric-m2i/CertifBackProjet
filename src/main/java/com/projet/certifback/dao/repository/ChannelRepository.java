package com.projet.certifback.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projet.certifback.dao.entity.Channel;

@Repository
public interface ChannelRepository extends JpaRepository<Channel, Long> {

}
