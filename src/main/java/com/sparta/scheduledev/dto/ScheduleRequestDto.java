package com.sparta.scheduledev.dto;

import lombok.Getter;

@Getter
public class ScheduleRequestDto {
    private String username;
    private String password;
    private String title;
    private String contents;
}
