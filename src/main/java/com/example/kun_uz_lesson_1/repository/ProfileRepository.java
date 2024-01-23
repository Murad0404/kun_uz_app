package com.example.kun_uz_lesson_1.repository;

import com.example.kun_uz_lesson_1.entity.ProfileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProfileRepository extends JpaRepository<ProfileEntity, Integer> {

    Optional<ProfileEntity> findByEmail(String email);
    Optional<ProfileEntity> findByEmaileAndPassword(String email,String password);
}
