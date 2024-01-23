package com.example.kun_uz_lesson_1.service;

import com.example.kun_uz_lesson_1.dto.AuthDTO;
import com.example.kun_uz_lesson_1.dto.ProfileDTO;
import com.example.kun_uz_lesson_1.entity.ProfileEntity;
import com.example.kun_uz_lesson_1.exp.AppBadException;
import com.example.kun_uz_lesson_1.repository.ProfileRepository;
import com.example.kun_uz_lesson_1.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    private ProfileRepository profileRepository;

    /**
     * buyerda profilga kirish uchun method yozdik bu
     * emeil va password orqali profilni topadi bo'lsa ProfileDTO qaytaradi
     * bo'lmasa AppBadException tashlaydi
     * */
    public ProfileDTO auth(AuthDTO authDTO) {
       Optional<ProfileEntity> optionalProfile = profileRepository.findByEmaileAndPassword(authDTO.getEmail(), MD5Util.encode(authDTO.getPassword()));
        if (optionalProfile.isEmpty()){
            throw new AppBadException("Emeil or Password is wrong");
        }

        ProfileEntity profileEntity = optionalProfile.get();
        ProfileDTO profileDTO = new ProfileDTO();
        profileDTO.setName(profileEntity.getName());
        profileDTO.setSurname(profileEntity.getSurname());
        profileDTO.setRole(profileEntity.getRole());

        return profileDTO;
    }
}
