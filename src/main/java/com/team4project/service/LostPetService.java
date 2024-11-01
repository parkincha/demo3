package com.team4project.service;

import com.team4project.entity.LostPet;
import com.team4project.repository.LostPetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LostPetService {

    private final LostPetRepository lostPetRepository;

    @Autowired
    public LostPetService(LostPetRepository lostPetRepository) {
        this.lostPetRepository = lostPetRepository;
    }

    // 모든 신고 데이터 조회
    public List<LostPet> getAllLostPets() {
        return lostPetRepository.findAll();
    }

    // 새로운 신고 데이터 저장
    public LostPet addLostPet(LostPet lostPet) {
        return lostPetRepository.save(lostPet);
    }
}
