package com.team4project.board3.service;

import com.team4project.board3.dto.Board3RequestDTO;
import com.team4project.board3.dto.Board3ResponseDTO;
import com.team4project.board3.domain.Board3;
import com.team4project.board3.repository.Board3Repository;
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
        Board3 board = board3Repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Post not found"));
        return convertToResponseDTO(board);
    }

    public Board3ResponseDTO createPost(Board3RequestDTO requestDTO) {
        Board3 board = convertToEntity(requestDTO);
        Board3 savedBoard = board3Repository.save(board);
        return convertToResponseDTO(savedBoard);
    }

    public Board3ResponseDTO updatePost(Board3RequestDTO requestDTO) {
        Board3 board = board3Repository.findById(requestDTO.getId())
                .orElseThrow(() -> new RuntimeException("Post not found"));
        board.setTitle(requestDTO.getTitle());
        board.setContent(requestDTO.getContent());
        board.setAuthor(requestDTO.getAuthor());

        Board3 updatedBoard = board3Repository.save(board);
        return convertToResponseDTO(updatedBoard);
    }

    public void deletePost(Long id) {
        board3Repository.deleteById(id);
    }

    private Board3ResponseDTO convertToResponseDTO(Board3 board) {
        Board3ResponseDTO responseDTO = new Board3ResponseDTO();
        responseDTO.setId(board.getId());
        responseDTO.setTitle(board.getTitle());
        responseDTO.setContent(board.getContent());
        responseDTO.setAuthor(board.getAuthor());
        responseDTO.setCreatedAt(board.getCreatedAt());
        return responseDTO;
    }

    private Board3 convertToEntity(Board3RequestDTO requestDTO) {
        Board3 board = new Board3();
        board.setTitle(requestDTO.getTitle());
        board.setContent(requestDTO.getContent());
        board.setAuthor(requestDTO.getAuthor());
        return board;
    }
}


