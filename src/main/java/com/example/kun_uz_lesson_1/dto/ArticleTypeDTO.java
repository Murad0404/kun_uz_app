package com.example.kun_uz_lesson_1.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArticleTypeDTO {

    protected Integer id;
    private String order_number;
    private String name_uz;
    private String name_ru;
    private String name_en;
    protected LocalDateTime createdDate;
    protected LocalDateTime updatedDate;
    private Boolean visible;
}
