package com.example.kun_uz_lesson_1.controller;

import com.example.kun_uz_lesson_1.dto.ArticleTypeDTO;
import com.example.kun_uz_lesson_1.dto.JwtDTO;
import com.example.kun_uz_lesson_1.enums.AppLanguage;
import com.example.kun_uz_lesson_1.enums.ProfileRole;
import com.example.kun_uz_lesson_1.service.ArticleTypeService;
import com.example.kun_uz_lesson_1.util.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/articleType")
@RestController
public class ArticleTypeController {
    @Autowired
    private ArticleTypeService articleTypeService;

    @PostMapping
    public ResponseEntity<?> Create(@RequestBody ArticleTypeDTO articleTypeDTO,
                       @RequestHeader(value = "Authentication") String jwt) {
        JwtDTO jwtDTO = JWTUtil.decode(jwt);
        if (!jwtDTO.getRole().equals(ProfileRole.ADMIN)) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
        articleTypeService.create(articleTypeDTO);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping
    public ResponseEntity<?> getAll(@RequestHeader(value = "Authentication") String jwt) {
        JwtDTO jwtDTO = JWTUtil.decode(jwt);
        if (!jwtDTO.getRole().equals(ProfileRole.ADMIN)) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
        return ResponseEntity.ok(articleTypeService.getAll());
    }

    @GetMapping("/pages")
    public ResponseEntity<?> getAllPagin(@RequestParam(value = "page", defaultValue = "0") Integer page,
                                         @RequestParam(value = "size", defaultValue = "10") Integer size,
                                         @RequestHeader(value = "Authentication") String jwt) {
        JwtDTO jwtDTO = JWTUtil.decode(jwt);
        if (!jwtDTO.getRole().equals(ProfileRole.ADMIN)) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
        return ResponseEntity.ok(articleTypeService.getAllPage(page, size));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id,
                                     @RequestHeader(value = "Authentication") String jwt) {
        JwtDTO jwtDTO = JWTUtil.decode(jwt);
        if (!jwtDTO.getRole().equals(ProfileRole.ADMIN)) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
        return ResponseEntity.ok(articleTypeService.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateById(@PathVariable Integer id,
                                        @RequestBody ArticleTypeDTO articleTypeDTO,
                                        @RequestHeader(value = "Authentication") String jwt) {
        JwtDTO jwtDTO = JWTUtil.decode(jwt);
        if (!jwtDTO.getRole().equals(ProfileRole.ADMIN)) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
        return ResponseEntity.ok(articleTypeService.updateById(id, articleTypeDTO));
    }

    @DeleteMapping("/{id}")
    public Boolean deleteByid(@PathVariable Integer id,
                              @RequestHeader(value = "Authentication") String jwt) {
        JwtDTO jwtDTO = JWTUtil.decode(jwt);
        if (!jwtDTO.getRole().equals(ProfileRole.ADMIN)) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build().hasBody();
        }
        return articleTypeService.deleteById(id);
    }

    @GetMapping("/lang")
    public ResponseEntity<?> getLanguage(@RequestParam(value = "lang", defaultValue = "uz") AppLanguage language) {
        return ResponseEntity.ok(articleTypeService.getByLang(language));
    }
}
