package com.sparta.scheduledev.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NonNull;

@Getter
public class CommentRequestDto {
    @NotBlank
    private Long scheduleId; // 해당 일정 id
    @NotBlank
    private String username; // 작성 유저명
    @NotBlank
    private String contents; // 댓글 내용

}
