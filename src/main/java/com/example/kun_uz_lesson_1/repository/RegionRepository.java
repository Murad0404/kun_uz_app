package com.example.kun_uz_lesson_1.repository;

import com.example.kun_uz_lesson_1.entity.ArticleTypeEntity;
import com.example.kun_uz_lesson_1.entity.RegionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RegionRepository extends JpaRepository<RegionEntity,Integer> {
    Optional<RegionEntity> findAllByOrder_number(String order);
}
