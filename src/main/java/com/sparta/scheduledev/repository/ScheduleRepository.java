package com.sparta.scheduledev.repository;

import com.sparta.scheduledev.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

    // 수정시간 기준 내림차순 SQL 메서드 생성 가능
    List<Schedule> findAllByOrderByModifiedAtDesc();

}
