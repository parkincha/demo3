package com.team4project.board4.service;


import com.team4project.board4.domain.Cboard;
import com.team4project.board4.dto.CboardDTO;
import com.team4project.board4.dto.CpageRequestDTO;
import com.team4project.board4.dto.CpageResponseDTO;
import com.team4project.board4.repository.CboardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Log4j2
@RequiredArgsConstructor
@Transactional
public class CboardServiceImpl implements CboardService {

    private final ModelMapper modelMapper;
    private final CboardRepository cboardRepository;

    @Override
    public Long register(CboardDTO cboardDTO) {
        Cboard cboard = dtoToEntity(cboardDTO);
        Long cno = cboardRepository.save(cboard).getCno();
        return cno;
    }

    @Override
    public CboardDTO readOne(Long cno) {
        Optional<Cboard> result = cboardRepository.findByIdWithImages(cno);
        Cboard cboard = result.orElseThrow();
        CboardDTO cboardDTO = entityToDTO(cboard);
        return cboardDTO;
    }

    @Override
    public void modify(CboardDTO cboardDTO) {
        Optional<Cboard> result = cboardRepository.findById(cboardDTO.getCno());
        Cboard cboard = result.orElseThrow();
        cboard.change(cboardDTO.getTitle(), cboardDTO.getContent());
        cboard.clearImages();
        if(cboardDTO.getFileNames()!= null) {
            for (String fileName : cboardDTO.getFileNames()) {
                String[] arr = fileName.split("_");
                cboard.addImage(arr[0], arr[1]);
            }
        }
        cboardRepository.save(cboard);
    }

    @Override
    public void remove(Long cno) {
        cboardRepository.deleteById(cno);
    }

    @Override
    public CpageResponseDTO<CboardDTO> list(CpageRequestDTO cpageRequestDTO) {
        String[] types = cpageRequestDTO.getTypes();
        String keyword = cpageRequestDTO.getKeyword();
        Pageable pageable = (Pageable) cpageRequestDTO.getPageable("cno");
        Page<Cboard> result = cboardRepository.searchAll(types, keyword, pageable);

        List<CboardDTO> dtoList = result.getContent().stream()
                .map(cboard -> modelMapper.map(cboard, CboardDTO.class))
                .collect(Collectors.toList());

        return CpageResponseDTO.<CboardDTO>withAll()
                .cpageRequestDTO(cpageRequestDTO)
                .dtoList(dtoList)
                .total((int) result.getTotalElements())
                .build();
    }
}
