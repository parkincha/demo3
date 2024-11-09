package com.team4project.board3.service;

import com.team4project.board3.dto.Board3RequestDTO;
import com.team4project.board3.dto.Board3ResponseDTO;

import java.util.List;

public interface Board3Service {

    // 게시글 목록 조회
    List<Board3ResponseDTO> getAllPosts();

    // 게시글 단건 조회
    Board3ResponseDTO getPostById(Long id);

    // 게시글 작성
    Board3ResponseDTO createPost(Board3RequestDTO requestDTO);

    // 게시글 수정
    Board3ResponseDTO updatePost(Board3RequestDTO requestDTO);

    // 게시글 삭제
    void deletePost(Long id);
}
