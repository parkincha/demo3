package com.team4project.board3.controller;

import com.team4project.board3.dto.Board3RequestDTO;
import com.team4project.board3.dto.Board3ResponseDTO;
import com.team4project.board3.service.Board3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/board3")
public class Board3Controller {

    private final Board3Service board3Service;

    @Autowired
    public Board3Controller(Board3Service board3Service) {
        this.board3Service = board3Service;
    }

    // 게시글 목록 보기 (List)
    @GetMapping("/list")
    public String list(Model model) {
        List<Board3ResponseDTO> boards = board3Service.getAllPosts();
        model.addAttribute("boards", boards);
        return "board3/list";
    }

    // 게시글 읽기 (Read)
    @GetMapping("/view")
    public String view(@RequestParam Long id, Model model) {
        Board3ResponseDTO board = board3Service.getPostById(id);
        model.addAttribute("board", board);
        return "board3/view";
    }

    // 게시글 수정 폼 (Modify Form)
    @GetMapping("/edit")
    public String editForm(@RequestParam Long id, Model model) {
        Board3ResponseDTO board = board3Service.getPostById(id);
        model.addAttribute("board", board);
        return "board3/edit";
    }

    // 게시글 수정 (Modify)
    @PostMapping("/update")
    public String update(Board3RequestDTO board3RequestDTO) {
        board3Service.updatePost(board3RequestDTO);
        return "redirect:/board3/view?id=" + board3RequestDTO.getId();
    }

    // 게시글 삭제 (Delete)
    @PostMapping("/delete")
    public String delete(@RequestParam Long id) {
        board3Service.deletePost(id);
        return "redirect:/board3/list";
    }
}

