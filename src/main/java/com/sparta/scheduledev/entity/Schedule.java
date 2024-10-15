package com.sparta.scheduledev.entity;


import com.sparta.scheduledev.dto.ScheduleRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "schedule")
@NoArgsConstructor
public class Schedule extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // nullable :  null 허용 여부
    // unique : 중복 허용 여부(false일 때 중복 허용)

    // 작성자
    @Column(name = "username", nullable = false, unique = true)
    private String username;

    // 비밀번호
    // length에 몇으로 넣어야 할지 질문해보자
    @Column(name = "password", nullable = false, length = 20)
    private String password;

    // 제목
    @Column(name = "title", nullable = false, length = 500)
    private String title;

    // 내용
    @Column(name = "contents", nullable = false, length = 500)
    private String contents;

    // 등록일
    @Column(name = "createdAt", nullable = false)
    private LocalDateTime createdAt;

    // 수정일
    @Column(name = "modifiedAt", nullable = false)
    private LocalDateTime modifiedAt;



    public Schedule(ScheduleRequestDto requestDto) {
        this.username = requestDto.getUsername();
        this.password = requestDto.getPassword();
        this.title = requestDto.getTitle();
        this.contents = requestDto.getContents();
        this.createdAt = LocalDateTime.now(); // 생성 시점 기록
        this.modifiedAt = LocalDateTime.now(); // 생성 시점과 동일해야 함

    }

    public void update(ScheduleRequestDto requestDto) {
        this.username = requestDto.getUsername();
        this.password = requestDto.getPassword();
        this.title = requestDto.getTitle();
        this.contents = requestDto.getContents();
        this.modifiedAt = LocalDateTime.now(); // 수정 시점 업데이트

    }
}
