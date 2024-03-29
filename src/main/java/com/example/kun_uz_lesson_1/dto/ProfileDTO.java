package com.example.kun_uz_lesson_1.dto;

import com.example.kun_uz_lesson_1.enums.ProfileRole;
import com.example.kun_uz_lesson_1.enums.ProfileStatus;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProfileDTO {

    protected Integer id;
    private String name;
    private String surname;
    private String email;
    private String phone;
    private String password;
    private ProfileStatus status;
    private ProfileRole role;
    protected LocalDateTime createdDate;
    protected LocalDateTime updatedDate;
    private Boolean visible;
    private String jwt;
}
