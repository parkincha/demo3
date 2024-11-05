package com.team4project.service;

import com.team4project.domain.Board1;
import com.team4project.repository.Board1Repository;
import com.team4project.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class Board1Service {

    @Autowired
    private Board1Repository board1Repository;

    public List<Board1> listByType(String postType) { //게시글의 유형 타입 지정(관리자글, 일반유저글
        return board1Repository.findByPostType(postType);
    }

    public Board1 insert(Board1 board1, User user) { // 반환 타입을 Board1로 변경
        board1.setUser(user);
        return board1Repository.save(board1); // 저장된 board1 객체를 반환
    }

    public Board1 findById(Long id) {
        return board1Repository.findById(id).orElseThrow();
    }
}
