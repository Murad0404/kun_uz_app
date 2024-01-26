package com.example.kun_uz_lesson_1.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "Region")
public class RegionEntity extends BaseEntity {
    @Column(nullable = false, unique = true)
    private String orderNumber;
    @Column(nullable = false)
    private String name_uz;
    @Column(nullable = false)
    private String name_ru;
    @Column(nullable = false)
    private String name_en;
}
