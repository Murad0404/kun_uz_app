package com.example.kun_uz_lesson_1.service;

import com.example.kun_uz_lesson_1.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileService {

    @Autowired
    private ProfileRepository profileRepository;
}
