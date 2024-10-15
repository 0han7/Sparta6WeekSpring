package com.sparta.scheduledev.service;

import com.sparta.scheduledev.dto.ScheduleRequestDto;
import com.sparta.scheduledev.dto.ScheduleResponseDto;
import com.sparta.scheduledev.entity.Schedule;
import com.sparta.scheduledev.repository.ScheduleRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    public ScheduleService(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    // 일정 등록
    public ScheduleResponseDto createSchedule(ScheduleRequestDto requestDto){
        // RequestDto -> Entity
        Schedule schedule = new Schedule(requestDto);

        // DB 저장
        Schedule saveSchedule = scheduleRepository.save(schedule);

        // Entity -> ResponseDto
        ScheduleResponseDto scheduleResponseDto = new ScheduleResponseDto(saveSchedule);

        return scheduleResponseDto;
    }

    // 일정 조회
    public List<ScheduleResponseDto> getSchedule() {
        // DB 조회
        return scheduleRepository.findAll().stream().map(ScheduleResponseDto::new).toList();
    }


    // 일정 수정
    @Transactional
    public Long updateSchedule(Long id, ScheduleRequestDto requestDto) {

        // 해당 일정이 DB에 존재하는지 확인
        Schedule schedule = findSchedule(id);

        // 일정 내용 수정
        schedule.update(requestDto);

        return id;
    }

    // 일정 삭제
    public Long deleteSchedule(Long id) {
        // 해당 일정이 DB에 존재하는지 확인
        Schedule schedule = findSchedule(id);

        // 일정 삭제
        scheduleRepository.delete(schedule);

        return id;
    }

    // findSchedule
    private Schedule findSchedule(Long id){
        return scheduleRepository.findById(id).orElseThrow(() ->
            new IllegalArgumentException("선택한 일정이 존재하지 않습니다.")
        );
    }
}

