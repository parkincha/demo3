package com.team4project.repository;

import com.team4project.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Board,Long> {
}
