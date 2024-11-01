package com.team4project.controller;

import com.team4project.entity.LostPet;
import com.team4project.service.LostPetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lostPets")
public class LostPetController {

    private final LostPetService lostPetService;

    @Autowired
    public LostPetController(LostPetService lostPetService) {
        this.lostPetService = lostPetService;
    }

    // 모든 신고 조회
    @GetMapping
    public List<LostPet> getAllLostPets() {
        return lostPetService.getAllLostPets();
    }

    // 신고 데이터 저장
    @PostMapping
    public LostPet addLostPet(@RequestBody LostPet lostPet) {
        return lostPetService.addLostPet(lostPet);
    }
}