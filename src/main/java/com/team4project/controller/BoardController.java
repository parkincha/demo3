package com.team4project.controller;

import com.team4project.config.auth.PrincipalDetails;
import com.team4project.domain.Board;
import com.team4project.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/board")
public class BoardController {
    @Autowired
    private BoardService boardService;

    @GetMapping("/insert")
    public String insert() {
        return "board/register";
    }
    @PostMapping("/insert")
    public String insert(Board board, @AuthenticationPrincipal PrincipalDetails principalDetails) {
        boardService.insert(board, principalDetails.getUser());
        return "redirect:/board/list";
    }
    @GetMapping("/view")
    public String view(@RequestParam Long num, Model model) {
        model.addAttribute("board", boardService.findById(num));
        return "board/view";
    }
    @GetMapping("/modify")
    public String update(@RequestParam Long num, Model model) {
        model.addAttribute("board", boardService.findById(num));
        return "board/modify";
    }
    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("lists", boardService.list());
        return "board/list";
    }
/*    @PostMapping("/update")
    public String update(Board board) {
        boardService.update(board);
        return "redirect:/board/view?num=" + board.getNum();*/
   /* }
    @GetMapping("/delete")
    public String delete(@RequestParam Long num) {
        boardService.delete(num);
        return "redirect:/board/list";
    }*/

}
