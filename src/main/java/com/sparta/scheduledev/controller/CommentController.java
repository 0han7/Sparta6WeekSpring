package com.sparta.scheduledev.controller;

import com.sparta.scheduledev.dto.CommentRequestDto;
import com.sparta.scheduledev.dto.CommentResponseDto;
import com.sparta.scheduledev.service.CommentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api")
@RestController
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }


    // 댓글 조회
    @GetMapping("/comment")
    public List<CommentResponseDto> getComment() {
        return commentService.getComment();
    }


    // 댓글 등록
    @PostMapping("/comment")
    public CommentResponseDto createComment(@RequestBody CommentRequestDto requestDto) {
        return commentService.createComment(requestDto);
    }

    // 댓글 수정
    @PutMapping("/comment/{id}")
    public Long updateComment(@PathVariable Long id, @RequestBody CommentRequestDto requestDto) {
        return commentService.updateComment(id, requestDto);

    }


    // 댓글 삭제
    @DeleteMapping("comment/{id}")
    public Long deleteComment(@PathVariable Long id) {
        return commentService.deleteComment(id);
    }
}
