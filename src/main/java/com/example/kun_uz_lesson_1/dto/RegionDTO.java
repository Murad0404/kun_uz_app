package com.example.kun_uz_lesson_1.dto;

import com.example.kun_uz_lesson_1.enums.AppLanguage;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RegionDTO {
    protected Integer id;
    private String order_number;
    private String name_uz;
    private String name_ru;
    private String name_en;
    private String name;
    protected LocalDateTime createdDate ;
    protected LocalDateTime updatedDate;
    private Boolean visible;

}
