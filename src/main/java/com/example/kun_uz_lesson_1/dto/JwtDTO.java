package com.example.kun_uz_lesson_1.dto;

import com.example.kun_uz_lesson_1.enums.ProfileRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class JwtDTO {
    private Integer id;
    private ProfileRole role;
}
