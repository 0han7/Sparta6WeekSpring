package com.sparta.scheduledev.dto;

import lombok.Getter;

@Getter
public class ScheduleResponseDto {
    private Long id;
    private String username;
    private String password;
    private String title;
    private String contents;
    // 등록 시간
    // 수정 시간
}
