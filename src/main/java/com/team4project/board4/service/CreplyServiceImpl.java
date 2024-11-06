package com.team4project.board4.service;

import com.team4project.board4.domain.Creply;
import com.team4project.board4.dto.CpageRequestDTO;
import com.team4project.board4.dto.CpageResponseDTO;
import com.team4project.board4.dto.CreplyDTO;
import com.team4project.board4.repository.CreplyRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Log4j2
@RequiredArgsConstructor
@Service
public class CreplyServiceImpl implements CreplyService{

    private final CreplyRepository creplyRepository;
    private final ModelMapper modelMapper;

    @Override
    public Long register(CreplyDTO creplyDTO) {
        Creply creply = modelMapper.map(creplyDTO, Creply.class);
        Long rno = creplyRepository.save(creply).getRno();
        return rno;
    }

    @Override
    public CreplyDTO read(Long rno) {
        Optional<Creply> creplyOptional = creplyRepository.findById(rno);
        Creply creply = creplyOptional.orElseThrow();
        return modelMapper.map(creply, CreplyDTO.class);
    }

    @Override
    public void modify(CreplyDTO creplyDTO) {
        Optional<Creply> creplyOptional = creplyRepository.findById(creplyDTO.getRno());
        Creply creply = creplyOptional.orElseThrow();
        creply.changeText(creplyDTO.getReplyText());
        creplyRepository.save(creply);
    }

    @Override
    public void remove(Long rno) {
        creplyRepository.deleteById(rno);
    }

    @Override
    public CpageResponseDTO<CreplyDTO> getListOfCboard(Long cno, CpageRequestDTO cpageRequestDTO) {
        Pageable pageable = PageRequest.of(cpageRequestDTO.getPage()
                <=0? 0: cpageRequestDTO.getPage()-1,
                cpageRequestDTO.getSize(),
                Sort.by("rno").ascending());
        Page<Creply> result = creplyRepository.listOfCboard(cno, pageable);

        List<CreplyDTO> dtoList = result.getContent().stream()
                .map(creply -> modelMapper.map(creply, CreplyDTO.class))
                .collect(Collectors.toList());

        return null;
    }
}
