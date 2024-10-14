package com.sparta.scheduledev.service;

import com.sparta.scheduledev.dto.ScheduleRequestDto;
import com.sparta.scheduledev.dto.ScheduleResponseDto;
import com.sparta.scheduledev.entity.Schedule;

import java.util.List;

public class ScheduleService {

    // 일정 등록
    public ScheduleResponseDto createSchedule(ScheduleRequestDto requestDto){
        // RequestDto -> Entity
        Schedule schedule = new Schedule();

        return scheduleResponseDto;
    }

    // 일정 조회
    public List<ScheduleResponseDto> getSchedule() {
        // DB 조회
        return new ScheduleResponseDto(); // 매개변수 대입
    }

    // 일정 수정
    public Long updateSchedule(Long id, ScheduleRequsetDto requsetDto) {
        return null;
    }

    // 일정 삭제
    public Long deleteSchdule(Long id) {
        return null;
    }

    // findById
    private Schedule findById(Long id){
        return null;
    }

}

