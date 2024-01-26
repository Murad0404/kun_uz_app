package com.example.kun_uz_lesson_1.controller;

import com.example.kun_uz_lesson_1.dto.JwtDTO;
import com.example.kun_uz_lesson_1.dto.RegionDTO;
import com.example.kun_uz_lesson_1.enums.AppLanguage;
import com.example.kun_uz_lesson_1.enums.ProfileRole;
import com.example.kun_uz_lesson_1.service.RegionService;
import com.example.kun_uz_lesson_1.util.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/region")
public class RegionController {

    @Autowired
    private RegionService regionService;
    @PostMapping
    public ResponseEntity<RegionDTO> create(@RequestBody RegionDTO regionDTO,
                                            @RequestHeader(value = "Authentication")String jwt) {
        JwtDTO jwtDTO = JWTUtil.decode(jwt);
        if (!jwtDTO.getRole().equals(ProfileRole.ADMIN)){
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
        return ResponseEntity.ok(regionService.create(regionDTO));
    }

    @GetMapping
    public ResponseEntity<?> getAll( @RequestHeader(value = "Authentication")String jwt) {
        JwtDTO jwtDTO = JWTUtil.decode(jwt);
        if (!jwtDTO.getRole().equals(ProfileRole.ADMIN)){
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
        return ResponseEntity.ok(regionService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id,
                                     @RequestHeader(value = "Authentication")String jwt) {
        JwtDTO jwtDTO = JWTUtil.decode(jwt);
        if (!jwtDTO.getRole().equals(ProfileRole.ADMIN)){
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
        return ResponseEntity.ok(regionService.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateById(@PathVariable Integer id, @RequestBody RegionDTO regionDTO,
                                        @RequestHeader(value = "Authentication")String jwt) {
        JwtDTO jwtDTO = JWTUtil.decode(jwt);
        if (!jwtDTO.getRole().equals(ProfileRole.ADMIN)){
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
        return ResponseEntity.ok(regionService.updateById(id, regionDTO));
    }

    @DeleteMapping("/{id}")
    public Boolean deleteByid(@PathVariable Integer id,
                              @RequestHeader(value = "Authentication")String jwt) {
        JwtDTO jwtDTO = JWTUtil.decode(jwt);
        if (!jwtDTO.getRole().equals(ProfileRole.ADMIN)){
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build().hasBody();
        }
        return regionService.deleteById(id);
    }

    @GetMapping("/lang")
    public ResponseEntity<?> getLanguage(@RequestParam(value = "lang",defaultValue = "uz")AppLanguage language) {
        return ResponseEntity.ok(regionService.getByLang(language));
    }
}
