package com.team4project.repository;

import com.team4project.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> { //JpaRepository 인터페이스를 상속받아 User 엔티티를 관리(저장, 조회, 삭제, 수정)하는 인터페이스 생성
    User findByUserId(String userId);
}