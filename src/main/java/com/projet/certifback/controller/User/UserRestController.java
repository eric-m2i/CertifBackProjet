package com.projet.certifback.controller.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projet.certifback.controller.user.dto.UserDTO;
import com.projet.certifback.controller.user.dto.UserMapper;
import com.projet.certifback.controller.user.dto.UserPostDTO;
import com.projet.certifback.dao.entity.User;
import com.projet.certifback.service.ChatService;

@RestController
@RequestMapping("/api/users")
public class UserRestController {
    @Autowired
    private ChatService chatService;

    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        List<User> entities = chatService.getAllUsers();
        List<UserDTO> dtos = new ArrayList<>();
        for (User entity : entities)
            dtos.add(UserMapper.convertFromEntityToDto(entity));

        return ResponseEntity.ok().body(dtos);
    }

    @GetMapping("{userId}")
    public ResponseEntity<?> getUserById(@PathVariable("userId") Long id) {
        User entity = chatService.getUserById(id);
        if (entity == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
        UserDTO dto = UserMapper.convertFromEntityToDto(entity);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody UserPostDTO UserPostDTO) {
        User newUser = UserMapper.convertFromDtoToEntity(UserPostDTO);
        try {
            chatService.saveUser(newUser);
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body("User created successfully");
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .body("Error: JSON");
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error: " + e.getMessage());
        }
    }

}
