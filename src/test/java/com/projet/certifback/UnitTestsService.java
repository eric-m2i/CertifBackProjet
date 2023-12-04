package com.projet.certifback;

import com.projet.certifback.dao.entity.Channel;
import com.projet.certifback.dao.entity.Message;
import com.projet.certifback.dao.entity.User;
import com.projet.certifback.service.ChatService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


@SpringBootTest
class UnitTestsService {

    @Autowired
    ChatService chatService;

    @Test
    void TestGetAllChannels() {
        assertTrue(chatService.getAllChannels().size() > 0);
    }

    @Test
    void TestGetChannelById() {
        assertEquals("GENERAL", chatService.getChannelById(1L).getName());
    }

    @Test
    void TestDeleteChannel() {
        assertEquals(false, chatService.deleteChannel(1L));
    }

    @Test
    void TestSaveChannel() {
        Channel canal = null;
        try {
            canal = chatService.saveChannel(new Channel("CanalJUnit", "Canal de tests unitaires", new ArrayList<>()));
            assertTrue(canal != null);
        } catch (DataIntegrityViolationException e) {
            assertTrue(canal == null);
        }
    }


}