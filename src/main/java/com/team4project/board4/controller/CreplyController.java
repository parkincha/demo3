package com.team4project.board4.controller;


import com.team4project.board4.dto.CpageRequestDTO;
import com.team4project.board4.dto.CpageResponseDTO;
import com.team4project.board4.dto.CreplyDTO;
import com.team4project.board4.service.CreplyService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.MediaType;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/creplies")
@Log4j2
@RequiredArgsConstructor
public class CreplyController {
    private final CreplyService creplyService;

    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, Long> register(
            @Valid @RequestBody CreplyDTO creplyDTO,
            BindingResult bindingResult) throws BindException {

        log.info(creplyDTO);

        if (bindingResult.hasErrors()) {
            throw new BindException(bindingResult);
        }

        Map<String,Long> resultMap = new HashMap<>();

        Long rno = creplyService.register(creplyDTO);

        resultMap.put("rno", rno);

        return resultMap;
    }
    @GetMapping(value = "/list/{cno}")
    public CpageResponseDTO<CreplyDTO> getList(@PathVariable("cno") Long cno,
                                               CpageRequestDTO cpageRequestDTO) {
        CpageResponseDTO<CreplyDTO> cpageresponseDTO = creplyService.getListOfCboard(cno, cpageRequestDTO);
        return cpageresponseDTO;
    }
    @DeleteMapping("/{rno}")
    public Map<String, Long> remove(@PathVariable("rno") Long rno) {
        creplyService.remove(rno);
        Map<String, Long> resultMap = new HashMap<>();
        resultMap.put("rno", rno);
        return resultMap;
    }




}
