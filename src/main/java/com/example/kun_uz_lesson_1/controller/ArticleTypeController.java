package com.example.kun_uz_lesson_1.controller;

import com.example.kun_uz_lesson_1.dto.ArticleTypeDTO;
import com.example.kun_uz_lesson_1.service.ArticleTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/articleType")
@RestController
public class ArticleTypeController {
    @Autowired
    private ArticleTypeService articleTypeService;

    @PostMapping
    public void Create(@RequestBody ArticleTypeDTO articleTypeDTO) {
       articleTypeService.create(articleTypeDTO);
    }

    @GetMapping
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(articleTypeService.getAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id){
       return ResponseEntity.ok(articleTypeService.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateById(@PathVariable Integer id,@RequestBody ArticleTypeDTO articleTypeDTO){
        return ResponseEntity.ok(articleTypeService.updateById(id,articleTypeDTO));
    }

    @DeleteMapping("/{id}")
    public Boolean deleteByid(@PathVariable Integer id){
        return articleTypeService.deleteById(id);
    }
}
