package com.team4project.board3.service;

import com.team4project.board3.dto.Board3RequestDTO;
import com.team4project.board3.dto.Board3ResponseDTO;
import com.team4project.board3.repository.Board3Repository;
import com.team4project.domain.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class Board3ServiceImpl implements Board3Service {

    private final Board3Repository board3Repository;

    @Autowired
    public Board3ServiceImpl(Board3Repository board3Repository) {
        this.board3Repository = board3Repository;
    }

    public List<Board3ResponseDTO> getAllPosts() {
        return board3Repository.findAll().stream()
                .map(this::convertToResponseDTO)
                .collect(Collectors.toList());
    }

    public Board3ResponseDTO getPostById(Long id) {
        Board board = board3Repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Post not found"));
        return convertToResponseDTO(board);
    }

    public Board3ResponseDTO createPost(Board3RequestDTO requestDTO) {
        Board board = convertToEntity(requestDTO);
        Board savedBoard = board3Repository.save(board);
        return convertToResponseDTO(savedBoard);
    }

    public Board3ResponseDTO updatePost(Board3RequestDTO requestDTO) {
        Board board = board3Repository.findById(requestDTO.getId())
                .orElseThrow(() -> new RuntimeException("Post not found"));
        board.setTitle(requestDTO.getTitle());
        board.setImageSet(requestDTO.getImage());
        board.setUser(requestDTO.getUser());

        Board updatedBoard = board3Repository.save(board);
        return convertToResponseDTO(updatedBoard);
    }

    public void deletePost(Long id) {
        board3Repository.deleteById(id);
    }

    private Board3ResponseDTO convertToResponseDTO(Board board) {
        Board3ResponseDTO responseDTO = new Board3ResponseDTO();
        responseDTO.setBno(board.getBno());
        responseDTO.setTitle(board.getTitle());
       // responseDTO.setContent(board.getContent());
        responseDTO.setUser(board.getUser());
        responseDTO.setCreatedAt(board.getCreatedAt());
        return responseDTO;
    }

    private Board convertToEntity(Board3RequestDTO requestDTO) {
        Board board = new Board();
        board.setTitle(requestDTO.getTitle());
       // board.setContent(requestDTO.getContent());
        board.setUser(requestDTO.getUser());
        return board;
    }
}


