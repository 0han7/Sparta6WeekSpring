package com.sparta.scheduledev.controller;

import com.sparta.scheduledev.dto.UserRequestDto;
import com.sparta.scheduledev.dto.UserResponseDto;
import com.sparta.scheduledev.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {
    private final UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }

    // 유저 조회
    @GetMapping("/user")
    public List<UserResponseDto> getUser() {
        return userService.getUser();
    }

    // 유저 생성
    @PostMapping("/user")
    public UserResponseDto createUser(@RequestBody UserRequestDto requestDto){
        return userService.createUser(requestDto);
    }

    // 유저 수정
    @PutMapping("/user/{id}")
    public Long updateUser(@PathVariable Long id, @RequestBody UserRequestDto requestDto) {
        return userService.updateUser(id, requestDto);
    }

    // 유저 삭제
    @DeleteMapping("/user/{id}")
    public Long deleteUser(@PathVariable Long id){
        return userService.deleteUser(id);
    }


}
