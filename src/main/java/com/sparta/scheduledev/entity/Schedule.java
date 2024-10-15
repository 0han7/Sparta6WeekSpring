package com.sparta.scheduledev.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "schedule")

public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // nullable :  null 허용 여부
    // unique : 중복 허용 여부(false일 때 중복 허용)

    //
    @Column(name = "username", nullable = false, unique = true)
    private String username;

    // length에 몇으로 넣어야 할지 질문해보자
    @Column(name = "password", nullable = false, length = 20)
    private String password;

    @Column(name = "title", nullable = false, length = 500)
    private String title;

    @Column(name = "contents", nullable = false, length = 500)
    private String contents;

    // 수정일
    // 등록일
}
