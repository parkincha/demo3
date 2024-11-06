package com.team4project.board4.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CboardDTO {

    private Long cno;
    @NotEmpty
    @Size(min = 2, max = 100)
    private String title;
    @NotEmpty
    private String content;
    @NotEmpty
    private String userId;

    private int visitcount;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private List<String> fileNames;
}



