package com.team4project.board4.service;

import com.team4project.board4.dto.CpageRequestDTO;
import com.team4project.board4.dto.CpageResponseDTO;
import com.team4project.board4.dto.CreplyDTO;

public interface CreplyService {

    Long register(CreplyDTO creplyDTO);

    CreplyDTO read(Long rno);

    void modify(CreplyDTO creplyDTO);

    void remove(Long rno);

    CpageResponseDTO<CreplyDTO> getListOfCboard(Long cno, CpageRequestDTO cpageRequestDTO);
}
