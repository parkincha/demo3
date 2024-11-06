package com.team4project.board4.repository;

import com.team4project.board4.domain.Cboard;
import com.team4project.board4.repository.search.CboardSearch;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CboardRepository extends JpaRepository<Cboard, Long>, CboardSearch {

    @EntityGraph(attributePaths = {"imageSet"})
    @Query("select  b from Cboard b where b.cno = :cno")
    Optional<Cboard> findByIdWithImages(Long cno);
}
