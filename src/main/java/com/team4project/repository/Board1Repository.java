package com.team4project.repository;

import com.team4project.domain.Board1;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface Board1Repository extends JpaRepository<Board1, Long> {
    List<Board1> findByPostType(String postType);
}