package com.sparta.scheduledev.entity;


import com.sparta.scheduledev.dto.UserRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "user")
@NoArgsConstructor

public class User extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 로그인
    @Column(name = "login", nullable = false, unique = true)
    private String login;


    // 패스워드
    @Column(name = "password", nullable = false, length = 20)
    private String password;

    // 이름
    @Column(name = "username", nullable = false,length = 10)
    private String username;


    // 이메일
    @Column(name = "email", nullable = false, length = 20)
    private String email;

    // 등록일
    @Column(name = "createdAt", nullable = false)
    private LocalDateTime createdAt;

    public User(UserRequestDto requestDto) {
        this.login = requestDto.getLogin();
        this.password = requestDto.getPassword();
        this.username = requestDto.getUsername();
        this.email = requestDto.getEmail();
        this.createdAt = LocalDateTime.now();

    }
}
