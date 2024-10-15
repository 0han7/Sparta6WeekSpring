package com.sparta.scheduledev.dto;


import com.sparta.scheduledev.entity.Comment;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CommentResponseDto {
    private Long id;
    private String username; // 작성 유저명
    private String contents; // 댓글 내용
    private LocalDateTime createdAt; // 작성일
    private LocalDateTime modifiedAt; // 수정일


    public CommentResponseDto(Comment comment) {
        this.id = comment.getId();
        this.username = comment.getUsername();
        this.contents = comment.getContents();
        this.createdAt = comment.getCreatedAt();
        this.modifiedAt = comment.getModifiedAt();
    }
}
