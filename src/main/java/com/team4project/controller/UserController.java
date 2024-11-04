package com.team4project.controller;

import com.team4project.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import com.team4project.domain.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/user")
@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @GetMapping("/join")
    public void join(){
    }

    @PostMapping("/register")
    public String register(User user){
        System.out.println("register user: " + user);
        String rawPassword = user.getPwd();
        String encPassword = bCryptPasswordEncoder.encode(rawPassword);
        user.setPwd(encPassword);
        user.setRole("USER"); // USER라는 role을 부여해서 user만 접근 가능하게
        userRepository.save(user);
        return "redirect:/user/login"; // 회원가입 후 로그인 페이지로 이동
    }

    @GetMapping("/login")
    public void login(){
    }
    @GetMapping("/home") //홈화면
    public void home(){
    }
}
