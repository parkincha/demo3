package com.team4project.domain.boardContent.color;

import com.team4project.domain.Board;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class PetColor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bno;

    @Enumerated(EnumType.STRING)
    private PetColorType color;

    @OneToOne(mappedBy = "petColor", fetch = FetchType.LAZY)
    private Board board;



}