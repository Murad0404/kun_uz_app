package com.example.kun_uz_lesson_1.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@MappedSuperclass
@Data
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;
    @Column(name = "created_date")
    protected LocalDateTime createdDate = LocalDateTime.now();
    @Column(name = "updated_date")
    protected LocalDateTime updatedDate;
    @Column(nullable = false)
    private Boolean visible = true;

}
