package com.example.kun_uz_lesson_1.entity;

import com.example.kun_uz_lesson_1.enums.ProfileRole;
import com.example.kun_uz_lesson_1.enums.ProfileStatus;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "profile")
public class ProfileEntity extends BaseEntity{

    private String name;
    @Column(nullable = false)
    private String surname;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String phone;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private ProfileStatus status;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private ProfileRole role;
   /* @Column(nullable = false)
    private String photo_id;*/


}
