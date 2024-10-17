package com.sparta.scheduledev.service;

import com.sparta.scheduledev.dto.UserRequestDto;
import com.sparta.scheduledev.dto.UserResponseDto;
import com.sparta.scheduledev.entity.User;
import com.sparta.scheduledev.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // 유저 조회
    public List<UserResponseDto> getUser() {

        // DB 조회
        return userRepository.findAllByOrderByModifiedAtDesc().stream().map(UserResponseDto::new).toList();
    }

    // 유저 등록
    public UserResponseDto createUser(UserRequestDto requestDto) {

        // RequsetDto -> Entity
        User user = new User(requestDto);

        // DB 저장
        User saveUser = userRepository.save(user);

        // Entity -> ResponseDto
        UserResponseDto userResponseDto = new UserResponseDto(saveUser);

        return userResponseDto;
    }


    // 유저 수정
    @Transactional
    public Long updateUser(Long id, UserRequestDto requestDto) {
        // 해당 유저 DB확인
        User user = findUser(id);

        // 유저 변경
        user.update(requestDto);

        return id;
    }


    // 유저 삭제
    public Long deleteUser(Long id) {
        // 해당 유저 DB 확인
        User user = findUser(id);

        // 유저 삭제
        userRepository.delete(user);

        return id;
    }

    //findUser
    private User findUser(Long id) {
        return userRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("선택한 유저가 존재하지 않습니다")
        );
    }


}
