package com.sparta.scheduledev.entity;

import com.sparta.scheduledev.dto.CommentRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "comment")
@NoArgsConstructor
public class Comment extends Timestamped{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 작성자
    @Column(name = "username", nullable = false)
    private String username;

    // 댓글 내용
    @Column(name = "contents", nullable = false, length = 500)
    private String contents;

    // 등록일
    @Column(name = "createdAt", nullable = false)
    private LocalDateTime createdAt;

    // 수정일
    @Column(name = "modifiedAt", nullable = false)
    private LocalDateTime modifiedAt;


    public Comment(CommentRequestDto requestDto) {
        this.username = requestDto.getUsername();
        this.contents = requestDto.getContents();
        this.createdAt = LocalDateTime.now(); // 생성 시점 기록
        this.modifiedAt = LocalDateTime.now();
    }



    public void update(CommentRequestDto requestDto) {
        this.username = requestDto.getUsername();
        this.contents = requestDto.getContents();
        this.modifiedAt = LocalDateTime.now(); // 수정 시 업데이트

    }
}
