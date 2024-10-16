package com.sparta.scheduledev.service;

import com.sparta.scheduledev.dto.CommentRequestDto;
import com.sparta.scheduledev.dto.CommentResponseDto;
import com.sparta.scheduledev.entity.Comment;
import com.sparta.scheduledev.entity.Schedule;
import com.sparta.scheduledev.entity.User;
import com.sparta.scheduledev.repository.CommentRepository;
import com.sparta.scheduledev.repository.ScheduleRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CommentService {


    private final CommentRepository commentRepository;
    private final ScheduleRepository scheduleRepository;

    public CommentService(CommentRepository commentRepository, ScheduleRepository scheduleRepository) {
        this.commentRepository = commentRepository;
        this.scheduleRepository = scheduleRepository;
    }

    // 댓글 조회
    public List<CommentResponseDto> getComment() {
        // DB 조회
        return commentRepository.findAllByOrderByModifiedAtDesc().stream().map(CommentResponseDto::new).toList();
    }

    // 댓글 등록
    public CommentResponseDto createComment(CommentRequestDto requestDto) {
        // RequestDto -> Entity
        Schedule schedule = scheduleRepository.findById(requestDto.getScheduleId()).orElseThrow(() ->
                new IllegalArgumentException("해당 일정이 없습니다."));

        Comment comment = new Comment(requestDto);
        comment.setSchedule(schedule); // Schedule 연결

        // DB 저장
        Comment saveComment = commentRepository.save(comment);

        // Entity -> ResponseDto
        CommentResponseDto commentResponseDto = new CommentResponseDto(saveComment);

        return commentResponseDto;
    }

    // 댓글 수정
    @Transactional
    public Long updateComment(Long id, CommentRequestDto requestDto) {

        // 해당 댓글이 DB에 존재하는지 확인
        Comment comment = findComment(id);

        // 댓글 내용 수정
        comment.update(requestDto);

        return id;

    }

    // 댓글 삭제
    public Long deleteComment(Long id) {
        // 해당 댓글이 DB에 존재하는지 확인
        Comment comment = findComment(id);

        // 댓글 삭제
        commentRepository.delete(comment);

        return id;
    }

    // findSchedule
    private Comment findComment(Long id) {
        return commentRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("선택한 댓글이 존재하지 않습니다.")
        );
    }
}
