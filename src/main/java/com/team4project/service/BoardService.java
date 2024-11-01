package com.team4project.service;


import com.team4project.domain.Board;
import com.team4project.domain.User;

import java.util.List;

public interface BoardService {
    void insert(Board board, User user);
    public List<Board> list();
    public Board findById(Long bno);
    public void update(Board board);
    public void delete(Long num);
}
