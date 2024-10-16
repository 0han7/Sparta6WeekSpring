package com.sparta.scheduledev.entity;


import com.sparta.scheduledev.dto.ScheduleRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

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

    // 1대 N관계
    @OneToMany(mappedBy = "schedule", cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, orphanRemoval = true)
    private List<Comment> commentList = new ArrayList<>();


    // N대 M관계
    @ManyToMany
    @JoinTable(name = "todoList",
            joinColumns = @JoinColumn(name = "schedule_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<User> userList = new ArrayList<>();

    // addUserList
    public void addUserList(User user) {
        this.userList.add(user); // 외래 키(연관 관계) 설정
        user.getScheduleList().add(this);
    }


    public Schedule(ScheduleRequestDto requestDto) {
        this.username = requestDto.getUsername();
        this.password = requestDto.getPassword();
        this.title = requestDto.getTitle();
        this.contents = requestDto.getContents();
    }

    public void update(ScheduleRequestDto requestDto) {
        this.username = requestDto.getUsername();
        this.password = requestDto.getPassword();
        this.title = requestDto.getTitle();
        this.contents = requestDto.getContents();
    }
}
