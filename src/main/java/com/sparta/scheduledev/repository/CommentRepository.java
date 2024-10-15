package com.sparta.scheduledev.repository;

import com.sparta.scheduledev.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    // 수정시간 기준 내림차순
    List<Comment> findAllByOrderByModifiedAtDesc();
}
