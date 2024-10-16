package com.sparta.scheduledev.dto;

import lombok.Getter;

@Getter
public class CommentRequestDto {
    private Long scheduleId; // 해당 일정 id
    private String username; // 작성 유저명
    private String contents; // 댓글 내용

}
