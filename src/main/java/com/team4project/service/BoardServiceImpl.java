package com.team4project.service;

import com.team4project.domain.Board;
import com.team4project.domain.User;
import com.team4project.repository.BoardRepository;
import lombok.RequiredArgsConstructor;



import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    private final BoardRepository boardRepository;

    @Override
    public void insert(Board board, User user) {
        board.setUser(user);
        boardRepository.save(board);

    }

    @Override
    public List<Board> list() {
        return boardRepository.findAll();
    }

    @Override
    public Board findById(Long bno) {
        return null;
    }

    @Override
    public void update(Board board) {

    }

    /*@Override
    public Board findById(Long num) {
        Board board = boardRepository.findById(num).get();
        board.updateHitcount(); // 조회수 증가
        return board;
    }

    @Override
    public void update(Board board) { // 게시글 수정
        Board oldBoard = boardRepository.findById(board.getNum()).get();
        oldBoard.setTitle(board.getTitle());
        oldBoard.setContent(board.getContent());
        boardRepository.save(oldBoard); // 수정된 게시글 저장
    }*/

    @Override
    public void delete(Long num) {
        boardRepository.deleteById(num);
        
    }
}
