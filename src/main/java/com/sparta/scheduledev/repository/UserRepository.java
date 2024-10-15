package com.sparta.scheduledev.repository;
import com.sparta.scheduledev.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findAllByOrderByModifiedAtDesc();

}
