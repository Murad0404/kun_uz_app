package com.example.kun_uz_lesson_1.repository;

import com.example.kun_uz_lesson_1.entity.ArticleTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ArticleTypeRepository extends JpaRepository<ArticleTypeEntity,Integer> {
    Optional<ArticleTypeEntity> findAllByOrderNumber(String order);
}
