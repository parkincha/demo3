package com.team4project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication(scanBasePackages = "com.team4project") // 프로젝트의 모든 패키지를 스캔
@EntityScan(basePackages = {"com.team4project.domain","com.team4project.board4.domain"}) // board3 도메인 내의 엔티티 스캔
public class Team4ProjectApplication {
    public static void main(String[] args) {
        SpringApplication.run(Team4ProjectApplication.class, args);
    }
}