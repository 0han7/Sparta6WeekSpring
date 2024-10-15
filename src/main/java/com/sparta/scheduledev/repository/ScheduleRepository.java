package com.sparta.scheduledev.repository;

import com.sparta.scheduledev.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
}
