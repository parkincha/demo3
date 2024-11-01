package com.team4project.repository;


import com.team4project.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username); //findByUsername() 메서드를 이용하여 사용자 정보를 조회

}
