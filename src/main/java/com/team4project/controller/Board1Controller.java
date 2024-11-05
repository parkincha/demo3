package com.team4project.controller;

import com.team4project.domain.Board1;
import com.team4project.service.Board1Service;
import com.team4project.config.auth.PrincipalDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/board1")
public class Board1Controller {

    @Autowired
    private Board1Service board1Service;

    @GetMapping("/insert")
    public String insert(@RequestParam String postType, Model model) {
        model.addAttribute("postType", postType);
        return "board1/register";
    }

    @PostMapping("/insert")
    public String insert(Board1 board1, @RequestParam String postType,
                         @AuthenticationPrincipal PrincipalDetails principalDetails) {
        board1.setPostType(postType);
        board1Service.insert(board1, principalDetails.getUser());
        return "redirect:/board1/list?postType=" + postType;
    }

    @GetMapping("/view")
    public String view(@RequestParam Long num, @RequestParam String postType, Model model) {
        model.addAttribute("board1", board1Service.findById(num));
        model.addAttribute("postType", postType);
        return "board1/view";
    }

    @GetMapping("/list")
    public String list(@RequestParam String postType, Model model) {
        model.addAttribute("lists", board1Service.listByType(postType));
        model.addAttribute("postType", postType);
        return "board1/list";
    }
}
