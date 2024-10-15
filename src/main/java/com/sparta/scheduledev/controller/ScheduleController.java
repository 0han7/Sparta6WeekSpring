package com.sparta.scheduledev.controller;

import com.sparta.scheduledev.dto.ScheduleRequestDto;
import com.sparta.scheduledev.dto.ScheduleResponseDto;
import com.sparta.scheduledev.service.ScheduleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class ScheduleController {

    // 일정 조회
    @GetMapping("/schedule")
    public List<ScheduleResponseDto> getSchedule() {
        ScheduleService scheduleService = new ScheduleService();
    }

    // 일정 등록
    @PostMapping("/schedule")
    public ScheduleResponseDto creatSchedule(ScheduleRequestDto requestDto) {
        ScheduleService scheduleService = new ScheduleService(); // 매개변수 추가
        return scheduleService.createSchedule(requestDto);
    }


    // 일정 수정
    @PutMapping("/schedule/{id}")
    public Long updateSchedule(@PathVariable Long id, @RequestBody ScheduleRequestDto requestDto) {
        ScheduleService scheduleService = new ScheduleService(); // 매개변수 추가
        return scheduleService.updateSchedule(id, requestDto);
    }

    // 일정 삭제
    @DeleteMapping("/schedule/{id}")
    public Long deleteSchedule(@PathVariable Long id){
        ScheduleService scheduleService = new ScheduleService(); // 매개변수 추가
        return scheduleService.deleteSchedule(id);
    }
}
