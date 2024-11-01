package com.team4project.repository;

import com.team4project.entity.LostPet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LostPetRepository extends JpaRepository<LostPet, Long>  {
}
