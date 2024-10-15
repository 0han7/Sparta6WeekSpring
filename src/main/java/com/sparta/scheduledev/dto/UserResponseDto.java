package com.sparta.scheduledev.dto;

import com.sparta.scheduledev.entity.User;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class UserResponseDto {
    private Long id;
    private String login;
    private String password;
    private String username;
    private String email;
    private LocalDateTime createdAt;

    public UserResponseDto(User user) {
        this.id = user.getId();
        this.login = user.getLogin();
        this.password = user.getPassword();
        this.username = user.getUsername();
        this.email = user.getEmail();
        this.createdAt = user.getCreatedAt();
    }
}
