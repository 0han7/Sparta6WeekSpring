package com.sparta.scheduledev.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Schedule {
    private Long id;
    private String username;
    private String password;
    private String title;
    private String contents;
    // 수정일
    // 등록일
}
