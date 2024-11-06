package com.team4project.board4.repository.search;

import com.team4project.board4.domain.Cboard;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CboardSearch {

    Page<Cboard> searchAll(String[] type, String keyword, Pageable pageable);
}
