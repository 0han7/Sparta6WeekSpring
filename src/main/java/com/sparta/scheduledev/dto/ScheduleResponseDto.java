package com.sparta.scheduledev.dto;

import com.sparta.scheduledev.entity.Schedule;
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

    public ScheduleResponseDto(Schedule schedule) {
        this.id = schedule.getId();
        this.username = schedule.getUsername();
        this.title = schedule.getTitle();
        this.contents = schedule.getContents();
        this.password = schedule.getPassword();
    }


}
