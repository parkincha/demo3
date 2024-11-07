package com.team4project;

import com.team4project.domain.Board1;
import com.team4project.domain.User;
import com.team4project.repository.Board1Repository;
import com.team4project.service.Board1Service;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class Board1ServiceTest {

    @Autowired
    private Board1Service board1Service;

    @Autowired
    private Board1Repository board1Repository;

    @AfterEach
    public void tearDown() {
        board1Repository.deleteAll(); // 테스트 후 데이터 정리
    }

    @Test
    public void testCreateBoard1() {
        // Given
        Board1 board1 = new Board1();
        board1.setTitle("Test Title");
        board1.setContent("Test Content");
        board1.setPostType("Test Type");

        User testUser = new User();
        testUser.setUsername("testUser"); // 필요한 경우 다른 필드도 설정

        // When
        Board1 savedBoard1 = board1Service.insert(board1, testUser);

        // Then
        Assertions.assertNotNull(savedBoard1.getId());
        Assertions.assertEquals("Test Title", savedBoard1.getTitle());
    }
}
