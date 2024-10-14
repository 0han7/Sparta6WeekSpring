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
    @GetMapping("/schedules")
    public List<ScheduleResponseDto> getSchedule() {
        ScheduleService scheduleService = new ScheduleService();
    }

    // 일정 등록
    @PostMapping("/schedules")
    public ScheduleResponseDto creatSchedule(ScheduleRequestDto scheduleRequestDto) {
        ScheduleService scheduleService = new ScheduleService(); // 매개변수 추가
        return scheduleService.createSchedule(reqestDto);
    }


    // 일정 수정
    @PutMapping("/schedules/{id}")
    public Long updateSchedule(@PathVariable Long id, @RequestBody ScheduleRequestDto requestDto) {
        ScheduleService scheduleService = new ScheduleService(); // 매개변수 추가
        return scheduleService.updateSchdule(id, requestDto);
    }

    // 일정 삭제
    @DeleteMapping("/schedules/{id}")
    public Long deleteSchedule(@PathVariable Long id){
        ScheduleService scheduleService = new ScheduleService(); // 매개변수 추가
        return scheduleService.deleteSchedule(id);
    }
}
