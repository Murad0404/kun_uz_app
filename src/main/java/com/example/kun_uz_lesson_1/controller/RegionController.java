package com.example.kun_uz_lesson_1.controller;

import com.example.kun_uz_lesson_1.dto.RegionDTO;
import com.example.kun_uz_lesson_1.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/region")
public class RegionController {

    @Autowired
    private RegionService regionService;
    @PostMapping
    public void Create(@RequestBody RegionDTO regionDTO) {
        regionService.create(regionDTO);
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(regionService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(regionService.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateById(@PathVariable Integer id, @RequestBody RegionDTO regionDTO) {
        return ResponseEntity.ok(regionService.updateById(id, regionDTO));
    }

    @DeleteMapping("/{id}")
    public Boolean deleteByid(@PathVariable Integer id) {
        return regionService.deleteById(id);
    }
}
